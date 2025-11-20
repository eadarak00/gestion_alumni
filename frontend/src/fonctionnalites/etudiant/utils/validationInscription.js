export const validerEmail = (email) => {
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
};

export const validerTelephone = (telephone) => {
  const regex = /^(\+221|00221)?[7][05678]\d{7}$/;
  return regex.test(telephone);
};

export const validerMotDePasse = (motDePasse) => {
  return motDePasse.length >= 8;
};

export const validerFormulaireInscription = (formData) => {
  const erreurs = {};

  if (!formData.nom || formData.nom.trim() === '') {
    erreurs.nom = 'Le nom est requis';
  }

  if (!formData.prenom || formData.prenom.trim() === '') {
    erreurs.prenom = 'Le prénom est requis';
  }

  if (!formData.email || !validerEmail(formData.email)) {
    erreurs.email = 'Email invalide';
  }

  if (!formData.username || formData.username.trim() === '') {
    erreurs.username = "Le nom d'utilisateur est requis";
  }

  if (!formData.motDePasse || !validerMotDePasse(formData.motDePasse)) {
    erreurs.motDePasse = 'Le mot de passe doit contenir au moins 8 caractères';
  }

  if (formData.motDePasse !== formData.confirmationMotDePasse) {
    erreurs.confirmationMotDePasse = 'Les mots de passe ne correspondent pas';
  }

  if (!formData.telephone || !validerTelephone(formData.telephone)) {
    erreurs.telephone = 'Numéro de téléphone invalide (ex: +221771234567)';
  }

  if (!formData.numeroCarteEtudiant || formData.numeroCarteEtudiant.trim() === '') {
    erreurs.numeroCarteEtudiant = 'Le numéro de carte étudiant est requis';
  }

  if (!formData.filiere || formData.filiere.trim() === '') {
    erreurs.filiere = 'La filière est requise';
  }

  if (!formData.niveau || formData.niveau.trim() === '') {
    erreurs.niveau = 'Le niveau est requis';
  }

  if (!formData.accepteConditions) {
    erreurs.accepteConditions = "Vous devez accepter les conditions d'utilisation";
  }

  return {
    valide: Object.keys(erreurs).length === 0,
    erreurs
  };
};
