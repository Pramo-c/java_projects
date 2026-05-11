import java.util.Scanner;


class Main{
  static char[][] board={{'1','2','3'},{'4','5','6'},{'7','8','9'}};

  static char currnetplayer='x';
  
  // display board
  static void printboard(){
    System.out.println();

    for(int i=0;i<3;i++){

      for(int j=0;j<3;j++){

        System.out.print(board[i][j]);

        if(j<2){
          System.out.print("|");
        }

      }
      System.out.println();
      if(i<2){
        System.out.println("-----");
      }
    }
    System.out.println();
  }

  //placemove
  static boolean placemove(int position){

    int row=(position-1)/3;
    int col=(position-1)%3;

    if(board[row][col] !='x' && board[row][col] != 'o'){
      board[row][col]=currnetplayer;
      return true;

    }

    return false;

  }
  
  //checking winner
  static boolean checkwinner(){

    //row
    for(int i=0;i<3;i++){
      if(board[i][0]==board[i][1] && board[i][1]==board[i][2]){
        return true;
      }
    }

    //columns
    for(int i=0;i<3;i++){
      if(board[0][i]==board[1][i] && board[1][i]==board[2][i]){
        return true;
      }
    }

    //cross
    if(board[0][0]==board[1][1] && board[1][1]==board[2][2]){
      return true;
    }

    if(board[0][2]==board[1][1] && board[1][1]==board[2][0]){
      return true;
    }
    return false;
  }
  
  //game is drow
  static boolean isdrow(){
    
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){

        if(board[i][j]!='x' && board[i][j]!='o'){
          return false;
        }
      }

    }
    
    return true; 
  }

  //switch player
  static void swithplayer(){

    if(currnetplayer=='x'){
      currnetplayer='o';
    }else{
      currnetplayer='x';
    }
  }


  public static void main(String[] args){

    Scanner input=new Scanner(System.in);


    while(true){
      
      printboard();

      System.out.println("player"+currnetplayer+"enter positon(0-9):");
      int position=input.nextInt();
      
      if(position < 1 || position>9){
        System.out.println("invalid input!");
        continue;

      }

      boolean success=placemove(position);

      if( !success ){
      System.out.println("position already takken !");

        continue;
      }

      if(checkwinner()){

        printboard();
        System.out.println("player   "+currnetplayer+"  5wins!");
        break;
      }

      if(isdrow()){

        printboard();
        System.out.println("Match is drow!");
        break;
      }
      swithplayer();
    }
   
  }
}