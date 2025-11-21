// import React from 'react';
// import CarteInformationFigma from '../../../composants/etudiant/CarteInformationFigma';
// import FormulaireInscriptionEtudiant from '../../../composants/etudiant/FormulaireInscriptionEtudiant';

// const InscriptionEtudiant = () => {
//   const handleInscriptionSuccess = (data) => {
//     console.log('Inscription et validation réussies:', data);
//     // Redirection vers la page de connexion après validation complète
//     setTimeout(() => {
//       window.location.href = '/connexion';
//     }, 1500);
//   };

//   return (
//     <div className="min-h-screen bg-gray-50 py-12 px-4 sm:px-6 lg:px-8">
//       <div className="max-w-[1400px] mx-auto">
//         <div className="flex flex-col lg:flex-row gap-16 items-center lg:items-start justify-center">
//           <div className="w-full lg:w-auto flex-shrink-0 order-2 lg:order-1">
//             <CarteInformationFigma />
//           </div>
//           <div className="w-full lg:w-auto lg:max-w-xl order-1 lg:order-2">
//             <FormulaireInscriptionEtudiant onSuccess={handleInscriptionSuccess} />
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default InscriptionEtudiant;


import React, { useState } from 'react';
import CarteInformationFigma from '../../../composants/etudiant/CarteInformationFigma';
import FormulaireInscriptionEtudiant from '../../../composants/etudiant/FormulaireInscriptionEtudiant';
import ModalValidationCode from '../../../composants/etudiant/ModalValidationCode';

const InscriptionEtudiant = () => {
  const [emailValidation, setEmailValidation] = useState(null); // email à valider
  const [modalOuverte, setModalOuverte] = useState(false);

  // Appelé quand inscription réussie dans le formulaire
  const handleInscriptionSuccess = (data) => {
    console.log('Inscription réussie :', data);
    // Ouvrir modal avec email à valider
    if (data && data.email) {
      setEmailValidation(data.email);
      setModalOuverte(true);
    }
  };

  // Appelé quand validation du code est réussie
  const handleValidationSuccess = () => {
    setModalOuverte(false);
    // Redirection vers connexion après petite pause
    setTimeout(() => {
      window.location.href = '/connexion';
    }, 1500);
  };

  // Fermer la modal (si besoin)
  const handleFermerModal = () => {
    setModalOuverte(false);
  };

  return (
    <div className="min-h-screen bg-gray-50 py-12 px-4 sm:px-6 lg:px-8">
      <div className="max-w-[1400px] mx-auto">
        <div className="flex flex-col lg:flex-row gap-16 items-center lg:items-start justify-center">
          <div className="w-full lg:w-auto flex-shrink-0 order-2 lg:order-1">
            <CarteInformationFigma />
          </div>
          <div className="w-full lg:w-auto lg:max-w-xl order-1 lg:order-2">
            <FormulaireInscriptionEtudiant onSuccess={handleInscriptionSuccess} />
          </div>
        </div>
      </div>

      {modalOuverte && (
        <ModalValidationCode
          isOpen={modalOuverte}
          onClose={handleFermerModal}
          email={emailValidation}
          onValidationSuccess={handleValidationSuccess}
        />
      )}
    </div>
  );
};

export default InscriptionEtudiant;
