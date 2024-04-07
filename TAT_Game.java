import java.util.Scanner;
class TicTacToe{
    char board[][];
    TicTacToe(){
        board=new char[3][3];
        initBoard();
    }
    void initBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }
    void DisplayBoard(){
        System.out.println("-------------");
        for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    int checkwin(){
        for (int i = 0; i <board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') return 1; 
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') return 1; 
        }
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) return 1; 
        return -1;

    }

    

    boolean availability(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==' '){
                    return true;
                }
            }
        }
        return false;
        
    }

    int placeInBoard(int x1,int y1,char ch){
      if(x1<=2 && x1>=0 && y1>=0 && y1<=2){
        if(board[x1][y1]==' '){
            board[x1][y1]=ch;
            DisplayBoard();
            return 1;
        }
        else return -1;
      }
      return 0;
    }
}

public class TAT_Game {
    public static void main(String []args){
        TicTacToe b=new TicTacToe();
        Scanner in=new Scanner(System.in);
        int flag=0,ax,by;
        while(true){
          if(b.availability()){
            if(flag==0){
                System.out.println("Human Turn");
                System.out.println("Enter the row and column Values");
                ax=in.nextInt();
                by=in.nextInt();
                int user=b.placeInBoard(ax,by,'X');
                if(user==1) flag=1;
                else if(user==0){
                    flag=0;
                    System.out.println("Invalid Index Position");
                }
                else{
                    System.out.println("Index Already Occupied");
                }
                int res=b.checkwin();
                if(res==1){
                    System.out.println("Human Won!!");
                    break;
                }
            }
            else{
                System.out.println("AI Turn");
                int x1,y1;
                x1=(int)(Math.random()*3);
                y1=(int)(Math.random()*3);
                int AI=b.placeInBoard(x1, y1, 'O');
                if(AI==1) flag=0;
                else if(AI==0){
                    flag=1;
                    System.out.println("Invalid Index Position");
                }
                else{
                    System.out.println("Index Already Occupied");
                }
                int res=b.checkwin();
                if(res==1){
                    System.out.println("AI Won!!");
                    break;
                }
            }
          }
          else{
            System.out.println("Draw");
            break;
          }
        }
    }
}
