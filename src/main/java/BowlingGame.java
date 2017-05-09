import java.util.*;
import java.util.regex.*;
public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        String[] sa=bowlingCode.split("\\|");
        ArrayList bowList=new ArrayList();
        int sum=0;
        for (int i = 0; i < sa.length; i++) {
            if(!sa[i].equals("")){
                bowList.add(sa[i]);
            }
        }
        String[] array=(String[])bowList.toArray(new String[bowList.size()+1]);
        String temp;
        if(array[10]!=null&&array[10].length()==2){
            temp=array[10];
            array[10]=String.valueOf(temp.charAt(0));
            array[11]=String.valueOf(temp.charAt(1));
        }
        for (int i = 0; i < 9; i++) {
            if(array[i].equals("X"))
            {
                sum+=10;
                if(array[i+1].equals("X")){
                    sum+=10;
                    if(array[i+2].equals("X"))
                    {
                        sum+=10;
                    }else if(Pattern.matches("[0-9]",String.valueOf(array[i+2].charAt(0)))){
                        sum+=Integer.parseInt(String.valueOf(array[i+2].charAt(0)));
                    }
                }else if(array[i+1].contains("/")){
                    sum+=10;
                }else{
                    if(Pattern.matches("[0-9]",String.valueOf(array[i+1].charAt(0)))){
                        sum+=Integer.parseInt(String.valueOf(array[i+1].charAt(0)));
                    }
                    if(Pattern.matches("[0-9]",String.valueOf(array[i+1].charAt(1)))){
                        sum+=Integer.parseInt(String.valueOf(array[i+1].charAt(1)));
                    }
                }
                System.out.println(sum);
            }
            else if(array[i].contains("/"))
            {
                sum += 10;
                if(array[i+1].equals("X"))
                {
                    sum+=10;
                }else if(Pattern.matches("[0-9]",String.valueOf(array[i+1].charAt(0))))
                {
                    sum+=Integer.parseInt(String.valueOf(array[i+1].charAt(0)));
                }
                System.out.println(sum);
            }
            else if(array[i].contains("-"))
            {
                if(Pattern.matches("[0-9]",String.valueOf(array[i].charAt(0)))){
                    sum+=Integer.parseInt(String.valueOf(array[i].charAt(0)));
                }else if(Pattern.matches("[0-9]",String.valueOf(array[i].charAt(1)))){
                    sum+=Integer.parseInt(String.valueOf(array[i].charAt(1)));
                }
                System.out.println(sum);
            }else{
                sum+=Integer.parseInt(String.valueOf(array[i].charAt(0)));
                sum+=Integer.parseInt(String.valueOf(array[i].charAt(1)));
                System.out.println(sum);
            }
        }
        if(array[9].equals("X")){
            sum+=10;
            if(array[10].equals("X")){
                sum+=10;
            }else if(Pattern.matches("[0-9]",array[10])){
                sum+=Integer.parseInt(array[10]);
            }
            if(array[11].equals("X")){
                sum+=10;
            }else if(Pattern.matches("[0-9]",array[11])){
                sum+=Integer.parseInt(array[11]);
            }
        }else if(array[9].contains("/")){
            sum+=10;
            if(array[10].equals("X")){
                sum+=10;
            }else if(Pattern.matches("[0-9]",array[10])){
                sum+=Integer.parseInt(array[10]);
            }
        }else if(array[9].contains("-")){
            if(Pattern.matches("[0-9]",String.valueOf(array[9].charAt(0)))){
                sum+=Integer.parseInt(String.valueOf(array[9].charAt(0)));
            }else if(Pattern.matches("[0-9]",String.valueOf(array[9].charAt(1)))){
                sum+=Integer.parseInt(String.valueOf(array[9].charAt(1)));
            }
        }else{
            sum+=Integer.parseInt(String.valueOf(array[9].charAt(0)));
            sum+=Integer.parseInt(String.valueOf(array[9].charAt(1)));
        }
        return sum;
    }
}
