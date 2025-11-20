import React from 'react';
import CarteInformationFigma from '../../../composants/etudiant/CarteInformationFigma';
import FormulaireInscriptionEtudiant from '../../../composants/etudiant/FormulaireInscriptionEtudiant';

const InscriptionEtudiant = () => {
  const handleInscriptionSuccess = (data) => {
    console.log('Inscription réussie:', data);
    setTimeout(() => {
      window.location.href = '/dashboard';
    }, 2000);
  };

  return (
    <div className="min-h-screen bg-gray-50 py-12 px-4 sm:px-6 lg:px-8">
      <div className="max-w-7xl mx-auto">
        <div className="flex flex-col lg:flex-row gap-8 items-start justify-center">
          <div className="w-full lg:w-auto flex-shrink-0 order-2 lg:order-1">
            <CarteInformationFigma />
          </div>

          <div className="w-full lg:flex-1 order-1 lg:order-2">
            <FormulaireInscriptionEtudiant onSuccess={handleInscriptionSuccess} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default InscriptionEtudiant;
