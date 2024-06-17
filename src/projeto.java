import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Perguntas do FAQ
public class projeto {
    private static String[] greetings = { "Olá!", "Oi!", "Bom dia!", "Boa tarde!", "Boa noite!" };
    private static String[] farewells = { "Tchau!", "Até mais!", "Adeus!", "Até logo!" };
    private static String[] faqQuestions = {
            "qual e o proposito deste projeto",
            "como uso o chatbot",
            "quais são as funcionalidades",
            "quem desenvolveu este projeto",
            "onde posso encontrar mais informacoes"
    };
    // Respostas do FAQ
    private static String[] faqAnswers = {
            "o Professor Raul desafiou alguns alunos a criar um chatbot com o conhecimento adquirido na aula e aqui estou eu.",
            "você pode interagir com o chatbot fazendo perguntas ou solicitando informações.",
            "as funcionalidades incluem responder a saudações, despedidas, fornecer a data e hora atual, e responder a perguntas frequentes.",
            "meu Criador são os futuros gênios da programação sendo eles o Guilherme, Luccas, Nycolas e Mateus.",
            "você pode encontrar mais informações no repositório do projeto ou na documentação fornecida.",
    };

    // Perguntas Criadas
    private static String[] dynamicQuestions = {
            "qual e o seu nome",
            "quem e voce",
            "o que voce faz",
            "qual e a sua cor favorita",
            "qual e a capital do brasil",
            "quantos anos voce tem",
            "voce gosta de musica",
            "qual e o seu filme favorito",
            "voce pode me contar uma piada",
            "qual e a sua comida favorita"
    };

    // Respostas das perguntas Acima
    private static String[] dynamicAnswers = {
            "eu sou o GrupoB02 desenvolvido para ajudar você com informações básicas.",
            "eu sou um chatbot criado para responder perguntas simples e realizar tarefas básicas.",
            "eu respondo perguntas e forneço informações úteis.",
            "eu gosto dessa pergunta, minha cor favorita é 10000000 em código binário ou cinza como você conhece!",
            "a capital do Brasil é Brasília.",
            "eu sou atemporal, então não tenho idade.",
            "eu não posso ouvir música, mas meus criadores gostam de muitos gêneros então eu sou eclético!",
            "eu não assisto filmes, mas 'O Poderoso Chefão' é um clássico popular.",
            "claro! Sabe o que são quatro pessoas felizes? São meus criadores, por estarem rodando este código!",
            "eu não como, mas dizem que uma picanha mal passada é uma das comidas mais deliciosas."
    };

    // Assim que iniciar, aparecerá as mensagens abaixo, e logo após seu nome
    // inserido, ele usará para responder suas perguntas
    public static void main(String[] args) {
        String nomeUsuario;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Grupo b02, teste no terminal nao utilizar acentuação qual é o seu nome?");
        nomeUsuario = scanner.nextLine();
        System.out.println("Olá " + nomeUsuario + ", como posso te ajudar?");

        while (true) {
            String userInput = scanner.nextLine().toLowerCase();
            if (userInput.equals("sair")) {
                System.out.println(getRandomFarewell());
                break;
            } else {
                processInput(nomeUsuario, userInput);
            }
        }
        scanner.close();
    }

    // Respostas para caso vc mandar bom dia/boa tarde/ boa noite, e perguntar sobre
    // o Tempo.
    private static void processInput(String nomeUsuario, String input) {
        if (containsKeyword(input, new String[] { "ola", "oi", "bom dia", "boa tarde", "boa noite" })) {
            System.out.println(nomeUsuario + ", " + getRandomGreeting());
        } else if (containsKeyword(input, new String[] { "tchau", "ate mais", "adeus", "ate logo" })) {
            System.out.println(nomeUsuario + ", " + getRandomFarewell());
        } else if (containsKeyword(input, new String[] { "data", "hora" })) {
            System.out.println(nomeUsuario + ", " + getCurrentDateTime());
        } else if (containsKeyword(input, new String[] { "tempo" })) {
            System.out.println(nomeUsuario + ", " + "não importa a cor do céu, você que faz seu dia bonito :)");
        } else {
            respondToDynamicOrFAQ(nomeUsuario, input);
        }
    }

    private static boolean containsKeyword(String input, String[] keywords) {
        for (String keyword : keywords) {
            if (input.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    // Essa parte do código, serve para responder data e horas atuais caso solicite
    // ao Chatbot
    private static String getRandomGreeting() {
        int index = (int) (Math.random() * greetings.length);
        return greetings[index];
    }

    private static String getRandomFarewell() {
        int index = (int) (Math.random() * farewells.length);
        return farewells[index];
    }

    private static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Data e hora atuais: " + sdf.format(new Date());
    }

    private static void respondToDynamicOrFAQ(String nomeUsuario, String input) {
        for (int i = 0; i < dynamicQuestions.length; i++) {
            if (input.contains(dynamicQuestions[i])) {
                System.out.println(nomeUsuario + ", " + dynamicAnswers[i]);
                return;
            }
        }
        for (int i = 0; i < faqQuestions.length; i++) {
            if (input.contains(faqQuestions[i])) {
                System.out.println(nomeUsuario + ", " + faqAnswers[i]);
                return;
            }
        }
        // Essa Mensagem aparecerá caso o Chatbot não entenda o que digitou, ou seja,
        // digitar algo não relacionado as perguntas que está Documentado
        System.out.println(nomeUsuario + ", " + "Desculpe, não entendi sua pergunta. Pode reformular?");
    }
}
