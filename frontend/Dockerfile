# frontend/dockerfile

# 1. Build du frontend
FROM node:18 AS build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build



# 2. Serveur NGINX (production)

FROM nginx:stable-alpine

# Copier les fichiers buildés de Vite dans nginx
COPY --from=build /app/dist /usr/share/nginx/html

# Supprimer config par défaut
RUN rm /etc/nginx/conf.d/default.conf

# Ajouter notre propre config
COPY nginx.conf /etc/nginx/conf.d/frontend.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
