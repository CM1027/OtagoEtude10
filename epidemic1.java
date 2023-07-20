import java.util.*;
import java.io.*;

public class epidemic1{
  public static void main(String[] args){
    try{File myFile = new File(args[0]);
      Scanner sc = new Scanner(myFile);
      ArrayList<char[]> chart = new ArrayList<char[]>();
      ArrayList<ArrayList<char[]>> all = new ArrayList<ArrayList<char[]>>();
      
      boolean changed = true;
      
      //read into array
      while (sc.hasNext()) {
        String line = sc.nextLine();
        if (!line.isEmpty()) {
          char[] s = (line.toCharArray());
          chart.add(s);
        }
        else {
          all.add(chart);
          chart = new ArrayList<char[]>();
        }
      }
      
      if (chart.size() != 0) {
        all.add(chart);
      }
      //end
      
      
      for(int i = 0; i < all.size(); i++){
        while(true){
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int row = 0; row < all.get(i).size(); row++){
          for(int col = 0; col < all.get(i).get(row).length; col++){
            //System.out.print(all.get(i).get(row)[col]);
            if(all.get(i).get(row)[col] == ('.')){
              //System.out.print("dot");
              int num = 0;
              if(all.get(i).size() == 1){
                if(col == 0){
                  //check right
                  if(all.get(i).get(row)[col+1] == ('S')){
                    num++;
                  }
                }else
                  if(col == all.get(i).get(row).length - 1){
                  //check left
                  if(all.get(i).get(row)[col-1] == ('S')){
                    num++;
                  }
                }else{
                  //check left
                  if(all.get(i).get(row)[col-1] == ('S')){
                    num++;
                  }
                  //check right
                  if(all.get(i).get(row)[col+1] == ('S')){
                    num++;
                  }
                }
              }
                else if(all.get(i).get(row).length == 1){
                if(row == 0){
                  //check down
                  if(all.get(i).get(row+1)[col] == ('S')){
                    num++;
                  }
                }else
                  if(row == all.get(i).size() - 1){
                  //check up
                  if(all.get(i).get(row-1)[col] == ('S')){
                    num++;
                  }
                }else{
                  //check up
                  if(all.get(i).get(row-1)[col] == ('S')){
                    num++;
                  }
                  //check down
                  if(all.get(i).get(row+1)[col] == ('S')){
                    num++;
                  }
                }
              }else   
              if(row == 0){
                if(col == 0){
                  //check right
                  if(all.get(i).get(row)[col+1] == ('S')){
                    num++;
                  }
                  //check down
                  if(all.get(i).get(row+1)[col] == ('S')){
                    num++;
                  }
                }else if(col == all.get(i).get(row).length - 1){
                  //check left
                  if(all.get(i).get(row)[col-1] == ('S')){
                    num++;
                  }
                  //check down
                  if(all.get(i).get(row+1)[col] == ('S')){
                    num++;
                  }
                }else{
                  //check left
                  if(all.get(i).get(row)[col-1] == ('S')){
                    num++;
                  }
                  //check right
                  if(all.get(i).get(row)[col+1] == ('S')){
                    num++;
                  }
                  //check down
                  if(all.get(i).get(row+1)[col] == ('S')){
                    num++;
                  }
                }
              }
              else if(row == all.get(i).size()-1){
                if(col == 0){
                  //check right
                  if(all.get(i).get(row)[col+1] == ('S')){
                    num++;
                  }
                  //check up;
                  if(all.get(i).get(row-1)[col] == ('S')){
                    num++;
                  }
                }else if (col == all.get(i).get(row).length -1){
                  //check left
                  if(all.get(i).get(row)[col-1] == ('S')){
                    num++;
                  }
                  //check up;
                  if(all.get(i).get(row-1)[col] == ('S')){
                    num++;
                  }
                }else{
                  //check left
                  if(all.get(i).get(row)[col-1] == ('S')){
                    num++;
                  }
                  //check up;
                  if(all.get(i).get(row-1)[col] == ('S')){
                    num++;
                  }
                  //check right
                  if(all.get(i).get(row)[col+1] == ('S')){
                    num++;
                  }
                }
              }
              else if(col == 0){
                //check down
                if(all.get(i).get(row+1)[col] == ('S')){
                  num++;
                }
                //check up;
                if(all.get(i).get(row-1)[col] == ('S')){
                  num++;
                }
                //check right
                if(all.get(i).get(row)[col+1] == ('S')){
                  num++;
                }
              }
              else if(col == all.get(i).get(row).length-1){
                //check left
                if(all.get(i).get(row)[col-1] == ('S')){
                  num++;
                }
                //check up;
                if(all.get(i).get(row-1)[col] == ('S')){
                  num++;
                }
                //check down
                if(all.get(i).get(row+1)[col] == ('S')){
                  num++;
                }
              }
              else{
                //check up, down, left, right
                //check left
                if(all.get(i).get(row)[col-1] == ('S')){
                  num++;
                }
                //check up;
                if(all.get(i).get(row-1)[col] == ('S')){
                  num++;
                }
                //check right
                if(all.get(i).get(row)[col+1] == ('S')){
                  num++;
                }
                //check down;
                if(all.get(i).get(row+1)[col] == ('S')){
                  num++;
                }
              }
              //System.out.print(num);
              if(num >= 2){
                all.get(i).get(row)[col] = 'S';
                al.add(1);  
              }
          }//end if
          }//end third for
          //System.out.println();
        } //end second for
        //System.out.println(al);
        if(al.size() == 0){
          break;
        }
        }
        //System.out.println();
      }//end first for
      
      
      
      //print out final result
      for(int a = 0; a < all.size(); a++){
        for(int row = 0; row < all.get(a).size(); row++){
          for(int col = 0; col < all.get(a).get(row).length; col++){
            System.out.print(all.get(a).get(row)[col]);
          }
          System.out.println();
        }
        System.out.println();
      }
      
    }catch(Exception e){
    }
    
  }
}