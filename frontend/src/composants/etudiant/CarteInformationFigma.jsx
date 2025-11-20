// import React from 'react';
// import { Check, Fingerprint } from 'lucide-react';

// const CarteInformationFigma = () => {
//   const avantages = [
//     "CV d'Exception - Créez un profil qui impressionne",
//     "Réseau d'Influence - Connectez avec des alumni inspirants",
//     "Mentorat Privilégié - Bénéficiez de conseils experts",
//     "Opportunités VIP - Accédez à des offres et formations exclusives"
//   ];

//   return (
//     <div className="bg-white rounded-3xl shadow-lg overflow-hidden w-full max-w-md">
//       <div className="flex flex-col items-center p-8">
//         <div className="w-24 h-24 mb-6 relative">
//           <div className="absolute inset-0 rounded-full border-4 border-gray-200 flex items-center justify-center">
//             <svg viewBox="0 0 100 100" className="w-full h-full">
//               <circle cx="50" cy="50" r="45" fill="white" stroke="#e5e7eb" strokeWidth="2"/>
//               <path d="M50,25 L55,25 C60,25 65,30 65,35 L65,45 L35,45 L35,35 C35,30 40,25 45,25 L50,25 Z" fill="#10b981" stroke="#10b981" strokeWidth="1.5"/>
//               <path d="M40,55 L45,60 L55,50 L60,55 C60,60 58,65 50,70 C42,65 40,60 40,55 Z" fill="#10b981" stroke="#10b981" strokeWidth="1.5"/>
//               <circle cx="50" cy="35" r="3" fill="#10b981"/>
//             </svg>
//           </div>
//         </div>

//         <div className="w-full h-2 bg-emerald-600 mb-8"></div>

//         <div className="w-32 h-32 mb-6 relative">
//           <div className="absolute inset-0 rounded-2xl border-4 border-emerald-100 bg-emerald-50 flex items-center justify-center">
//             <Fingerprint size={64} className="text-emerald-600" strokeWidth={1.5} />
//           </div>
//           <div className="absolute -top-3 -right-3 w-10 h-10 bg-emerald-600 rounded-full border-4 border-white"></div>
//           <div className="absolute -bottom-2 -left-2 w-8 h-8 bg-emerald-600 rounded-full opacity-50"></div>
//         </div>

//         <h3 className="text-xl font-bold text-gray-900 text-center mb-2">
//           Propulsez Votre Carrière avec Notre Communauté Alumni
//         </h3>

//         <div className="w-full space-y-3 mt-6">
//           {avantages.map((avantage, index) => (
//             <div key={index} className="flex items-start gap-3">
//               <div className="flex-shrink-0 w-5 h-5 rounded-full bg-emerald-600 flex items-center justify-center mt-0.5">
//                 <Check size={14} className="text-white" strokeWidth={3} />
//               </div>
//               <p className="text-sm text-gray-700 flex-1 leading-relaxed">{avantage}</p>
//             </div>
//           ))}
//         </div>
//       </div>
//     </div>
//   );
// };

// export default CarteInformationFigma;


import React from 'react';
import logoUasz from "../../assets/logos/uasz.jpg";
import { Check, Fingerprint } from 'lucide-react';

const avantages = [
  "CV d'Exception - Créez un profil qui impressionne",
  "Réseau d'Influence - Connectez avec des alumni inspirants",
  "Mentorat Privilégié - Bénéficiez de conseils experts",
  "Opportunités VIP - Accédez à des offres et formations exclusives"
];

const CarteInformationFigma = () => (
  <div className="bg-white rounded-3xl shadow-lg overflow-hidden w-full max-w-lg border border-neutral-100">
    {/* Logo UASZ centré */}
    <div className="flex flex-col items-center pt-8 pb-0">
      <img
        src={logoUasz}
        alt="Logo UASZ"
        className="h-30 w-30 object-contain mb-3"
      />
      <div className="w-full h-8 bg-emerald-600 rounded-b-2xl mb-10" />
    </div>
    
    <div className="flex flex-col items-center px-10 pb-10">
      <div className="w-36 h-36 mb-8 relative flex items-center justify-center">
        <div className="absolute inset-0 rounded-2xl border-4 border-emerald-100 bg-emerald-50 flex items-center justify-center" />
        <Fingerprint size={80} className="text-emerald-600 z-10" strokeWidth={1.5} />
        <div className="absolute -top-4 -right-4 w-12 h-12 bg-emerald-600 rounded-full border-4 border-white"></div>
        <div className="absolute -bottom-3 -left-3 w-10 h-10 bg-emerald-600 rounded-full opacity-50"></div>
      </div>
      
      <h3 className="text-2xl font-bold text-gray-900 text-center mb-3">
        Propulsez Votre Carrière avec Notre Communauté Alumni
      </h3>
      
      <div className="w-full space-y-4 mt-8">
        {avantages.map((avantage, index) => (
          <div key={index} className="flex items-start gap-4">
            <div className="flex-shrink-0 w-6 h-6 rounded-full bg-emerald-600 flex items-center justify-center mt-0.5">
              <Check size={16} className="text-white" strokeWidth={3} />
            </div>
            <p className="text-base text-gray-700 flex-1 leading-relaxed">{avantage}</p>
          </div>
        ))}
      </div>
    </div>
  </div>
);

export default CarteInformationFigma;