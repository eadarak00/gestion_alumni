import React, { useState } from 'react';
import PropTypes from 'prop-types';
import Bouton from '../commun/Bouton';
import ChampTexte from '../commun/ChampTexte';

const ModalValidationCode = ({ isOpen, onClose, email, onValidationSuccess }) => {
  const [code, setCode] = useState('');
  const [chargement, setChargement] = useState(false);
  const [chargementRenvoi, setChargementRenvoi] = useState(false);
  const [message, setMessage] = useState('');
  const [typeMessage, setTypeMessage] = useState(''); // 'success' ou 'error'

  if (!isOpen) return null;

  // Empêcher la fermeture pendant un chargement
  const handleClose = () => {
    if (!chargement && !chargementRenvoi) {
      onClose();
    }
  };

  const handleValider = async () => {
    if (!code.trim()) {
      setMessage('Veuillez entrer le code de validation');
      setTypeMessage('error');
      return;
    }

    // Vérifier que le code contient exactement 6 chiffres
    if (!/^\d{6}$/.test(code)) {
      setMessage('Le code doit contenir exactement 6 chiffres');
      setTypeMessage('error');
      return;
    }

    setChargement(true);
    setMessage('');

    try {
      const { validerCode } = await import('../../fonctionnalites/etudiant/api/inscription.api');
      const resultat = await validerCode(email, code);

      setChargement(false);

      if (resultat.success) {
        setMessage('✅ Compte validé avec succès ! Redirection...');
        setTypeMessage('success');
        setTimeout(() => {
          onValidationSuccess();
        }, 1500);
      } else {
        setMessage(resultat.message || '❌ Code invalide ou expiré');
        setTypeMessage('error');
      }
    } catch (error) {
      setChargement(false);
      setMessage('❌ Erreur lors de la validation');
      setTypeMessage('error');
      console.error(error);
    }
  };

  const handleRenvoyer = async () => {
    setChargementRenvoi(true);
    setMessage('');

    try {
      const { renvoyerCode } = await import('../../fonctionnalites/etudiant/api/inscription.api');
      const resultat = await renvoyerCode(email);

      setChargementRenvoi(false);

      if (resultat.success) {
        setMessage('✅ Nouveau code envoyé par email !');
        setTypeMessage('success');
        setCode(''); // Réinitialiser le champ
      } else {
        setMessage(resultat.message || '❌ Impossible d\'envoyer un nouveau code');
        setTypeMessage('error');
      }
    } catch (error) {
      setChargementRenvoi(false);
      setMessage('❌ Erreur lors de l\'envoi du code');
      setTypeMessage('error');
      console.error(error);
    }
  };

  // Gérer l'appui sur la touche Entrée
  const handleKeyPress = (e) => {
    if (e.key === 'Enter' && !chargement && !chargementRenvoi) {
      handleValider();
    }
  };

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
      <div className="bg-white rounded-xl shadow-2xl max-w-md w-full p-6 relative">
        {/* Bouton fermer */}
        <button
          onClick={handleClose}
          disabled={chargement || chargementRenvoi}
          className="absolute top-4 right-4 text-gray-400 hover:text-gray-600 transition-colors disabled:opacity-50 disabled:cursor-not-allowed"
        >
          <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M6 18L18 6M6 6l12 12" />
          </svg>
        </button>

        {/* Icône email */}
        <div className="flex justify-center mb-4">
          <div className="w-16 h-16 bg-emerald-100 rounded-full flex items-center justify-center">
            <svg className="w-8 h-8 text-emerald-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z" />
            </svg>
          </div>
        </div>

        {/* Titre */}
        <h2 className="text-2xl font-bold text-gray-900 text-center mb-2">
          Validez votre compte
        </h2>

        {/* Description */}
        <p className="text-gray-600 text-center mb-6 text-sm">
          Un code de validation a été envoyé à <br />
          <span className="font-semibold text-emerald-600">{email}</span>
        </p>

        {/* Champ code */}
        <div className="mb-4">
          <ChampTexte
            label="Code de validation"
            name="code"
            value={code}
            onChange={(e) => {
              // Accepter uniquement les chiffres (maximum 6)
              // SonarQube propose replaceAll, ce qui fonctionne aussi
              const val = e.target.value.replaceAll(/\D/g, '');
              setCode(val);
            }}
            onKeyPress={handleKeyPress}
            placeholder="Entrez le code à 6 chiffres"
            className="text-center text-2xl tracking-widest font-mono"
            maxLength={6}
            autoFocus
          />
        </div>

        {/* Message */}
        {message && (
          <div
            className={`mb-4 p-3 rounded-lg text-sm text-center ${
              typeMessage === 'success'
                ? 'bg-emerald-50 text-emerald-700 border border-emerald-200'
                : 'bg-red-50 text-red-700 border border-red-200'
            }`}
          >
            {message}
          </div>
        )}

        {/* Boutons */}
        <div className="space-y-3">
          <Bouton
            onClick={handleValider}
            fullWidth
            disabled={chargement || chargementRenvoi || code.length !== 6}
          >
            {chargement ? 'Validation en cours...' : 'Valider le code'}
          </Bouton>

          <div className="text-center">
            <p className="text-sm text-gray-600 mb-2">
              Vous n'avez pas reçu le code ?
            </p>
            <button
              onClick={handleRenvoyer}
              disabled={chargement || chargementRenvoi}
              className="text-emerald-600 hover:text-emerald-700 font-medium text-sm disabled:opacity-50 disabled:cursor-not-allowed transition-colors"
            >
              {chargementRenvoi ? 'Envoi en cours...' : 'Renvoyer un nouveau code'}
            </button>
          </div>
        </div>

        {/* Info */}
        <div className="mt-6 p-3 bg-blue-50 rounded-lg">
          <p className="text-xs text-blue-700 text-center">
             Le code est valide pendant 10 minutes
          </p>
        </div>
      </div>
    </div>
  );
};

ModalValidationCode.propTypes = {
  isOpen: PropTypes.bool.isRequired,
  onClose: PropTypes.func.isRequired,
  email: PropTypes.string.isRequired,
  onValidationSuccess: PropTypes.func.isRequired,
};

export default ModalValidationCode;
