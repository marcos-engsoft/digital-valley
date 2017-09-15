package model;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class Email {
    
    private String hostName = "smtp.gmail.com";
    private final int port = 587;
    private String fromEmail;
    private String message;
    private String assunto;
    private String user = "n2s.mensageiro";
    private String pass = "n2s@m@1ls3rv1c3";

    private String nomeTo;
    public Email(){
        super();
    }
    public Email(String assunto, String message, String fromEmail, String nome)
    {
        this.assunto = assunto;
        this.message = message;
        this.fromEmail = fromEmail;
        this.nomeTo = nome;
    }
    public void sendEmail() throws EmailException {
        try{
        	
        	//String[] ls = util.Facade.lerArquivoEmail();
        	//this.setUser(ls[0].trim());
        	//this.setPass(ls[1].trim());
        	
            SimpleEmail email = new SimpleEmail();
            //Utilize o hostname do seu provedor de email
            System.out.println("alterando hostname...");
            email.setHostName(hostName);
            //Quando a porta utilizada n�o � a padr�o (gmail = 465)
            email.setSmtpPort(port);
            //Adicione os destinat�rios
            email.addTo(this.fromEmail, this.nomeTo);
            //Configure o seu email do qual enviar�
            email.setFrom("n2s.mensageiro@gmail.com", "N2S - Controle de Acesso");
            //Adicione um assunto
            email.setSubject(this.assunto);
            //Adicione a mensagem do email
            email.setMsg(this.message);
            //Para autenticar no servidor � necess�rio chamar os dois m�todos abaixo
            System.out.println("autenticando...");
            email.setSSL(true);
            System.out.println(user+"----"+ pass);
            email.setAuthentication(user, pass);
            System.out.println("enviando...");
            email.send();
            System.out.println("Email enviado!");
        }catch(EmailException e){
            e.printStackTrace();;
	}
   }
    
    
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNomeTo() {
        return nomeTo;
    }

    public void setNomeTo(String nomeTo) {
        this.nomeTo = nomeTo;
    }

    
    

   
   
}