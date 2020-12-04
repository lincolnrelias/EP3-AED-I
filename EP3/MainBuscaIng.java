import java.io.File; // Classe para ler arquivos
import java.io.FileWriter;//Classe para escrever arquivos
import java.io.FileNotFoundException;//Classe para lidar com erro de arquivo nao encontrado
import java.io.IOException; // Classe para poder lidar com erros de E/S
import java.util.Scanner;

public class MainBuscaIng {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        while(true){
        System.out.println("Digite o numero de tarefas do arquivo que quiser buscar:(0 para sair)");
        String input = entrada.next();
        if(input.equals("0"))break;
        String filePath = "entradas/tarefas"+input+".txt";
        long time = System.currentTimeMillis();
        String result = ReadFile(filePath,gerarVerificador(input));
        long timePassed = System.currentTimeMillis()-time;
        System.out.println("Tempo de processamento: "+timePassed);
        WriteFile(input, result);  
        }
        entrada.close();
        
    }

    static BuscaIngenua gerarVerificador(String filepath) {
        String fPath = "verificar/verificar" + filepath+".txt";
        BuscaIngenua estVerif = new BuscaIngenua();
        File dir = new File(fPath);
        try {
            Scanner reader = new Scanner(dir);
            while (reader.hasNextLine()) {
                estVerif.insert(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return estVerif;

    }

    static String ReadFile(String filePath, BuscaIngenua estVerificador) {
        BuscaIngenua saida=new BuscaIngenua();
        try {
            File dir = new File(filePath);
            Scanner reader = new Scanner(dir);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                if(!data.equals("") && estVerificador.find(data)){
                    saida.insert(data);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Caminho para leitura do arquivo nao encontrado: "+e.getMessage());
        }
        return saida.toString();

    }
    static void WriteFile(String fileName,String resultString){
        try {
            String pathStr = "saidas/"+fileName+"Saida.txt";
            FileWriter writer = new FileWriter(pathStr);
            writer.write(resultString);
            writer.close();
            System.out.println("o arquivo "+fileName+ "Saida.txt"
              + " foi criado em saidas");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}