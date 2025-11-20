import axiosInstance from '../../../services/axios';

export const inscrireEtudiant = async (etudiantData) => {
  try {
    const response = await axiosInstance.post('/auth/inscription-etudiant', etudiantData);
    return {
      success: true,
      data: response.data
    };
  } catch (error) {
    return {
      success: false,
      message: error.response?.data?.message || 'Une erreur est survenue lors de l\'inscription',
      errors: error.response?.data?.errors || {}
    };
  }
};
