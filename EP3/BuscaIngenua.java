public class BuscaIngenua {
    protected final int MAX = 1000000;
    protected String[] arranjo;
    int size=0;
    BuscaIngenua(){arranjo=new String[MAX];}
    public void insert(String newElement){
        arranjo[size]=newElement;
        size++;
    }
    public boolean find(String searchElement){
        for(int i=0;i<size;i++){
            if(arranjo[i].equals(searchElement)) return true;
        }
        return false;
    }
    public String toString(){
    
        String format="";
        for(int i=0;i<=size-1;i++){
            format=format+arranjo[i]+"\n";
        }
        return format;
    }
}
