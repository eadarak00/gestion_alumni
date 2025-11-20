import { useState } from 'react';
import { inscrireEtudiant } from '../api/inscription.api';
import { validerFormulaireInscription } from '../utils/validationInscription';

export const useInscriptionEtudiant = () => {
  const [chargement, setChargement] = useState(false);
  const [erreurs, setErreurs] = useState({});
  const [message, setMessage] = useState('');

  const soumettre = async (formData) => {
    setErreurs({});
    setMessage('');

    const validation = validerFormulaireInscription(formData);

    if (!validation.valide) {
      setErreurs(validation.erreurs);
      return { success: false };
    }

    setChargement(true);

    const { confirmationMotDePasse, accepteConditions, ...etudiantData } = formData;

    const resultat = await inscrireEtudiant(etudiantData);

    setChargement(false);

    if (resultat.success) {
      setMessage('Inscription réussie ! Vous allez être redirigé...');
      return { success: true, data: resultat.data };
    } else {
      setMessage(resultat.message);
      setErreurs(resultat.errors || {});
      return { success: false, message: resultat.message };
    }
  };

  return {
    chargement,
    erreurs,
    message,
    soumettre
  };
};
