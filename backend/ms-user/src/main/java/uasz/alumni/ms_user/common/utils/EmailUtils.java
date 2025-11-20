package uasz.alumni.ms_user.common.utils;


public class EmailUtils {

    public static String sujetValidationInscription() {
        return "Validation de votre compte Utilisateur";
    }

    public static String corpsValidationInscriptionHTML(String nom, String code) {
        return String.format("""
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <style>
                        body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }
                        .container { max-width: 600px; margin: 0 auto; padding: 20px; }
                        .header { background-color: #007bff; color: white; padding: 20px; text-align: center; }
                        .content { background-color: #f9f9f9; padding: 30px; }
                        .code-box { background-color: #fff; border: 2px solid #007bff; padding: 20px; text-align: center; margin: 20px 0; }
                        .code { font-size: 32px; font-weight: bold; color: #007bff; letter-spacing: 5px; }
                        .footer { text-align: center; padding: 20px; font-size: 12px; color: #666; }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <div class="header">
                            <h1>Bienvenue sur Alumni UASZ</h1>
                        </div>
                        <div class="content">
                            <p>Bonjour <strong>%s</strong>,</p>
                            <p>Merci de vous être inscrit sur notre plateforme Alumni UASZ.</p>
                            <p>Pour activer votre compte, veuillez utiliser le code de validation ci-dessous :</p>
                            
                            <div class="code-box">
                                <div class="code">%s</div>
                            </div>
                            
                            <p><strong>Ce code est valide pendant 15 minutes.</strong></p>
                            <p>Si vous n'avez pas créé de compte, veuillez ignorer cet email.</p>
                        </div>
                        <div class="footer">
                            <p>© 2024 Alumni UASZ - Université Assane Seck de Ziguinchor</p>
                            <p>Cet email a été envoyé automatiquement, merci de ne pas y répondre.</p>
                        </div>
                    </div>
                </body>
                </html>
                """, nom, code);
    }

}