package by.training.server;

public class Person {

    private String name;

    public void jsonString(String string){
        String[] item = string.split("\\\"");
        for (int i = 1 ; i < item.length - 2; i+=2) {
            if(item[i].equals("name")){
                setName(item[i+2]);
            }
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
