/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.System.exit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author duane
 */

//shorten how to play
//extras i can add: additional playing options and more players.
public class BlackJack{
    public int hearts=0;
    public int diamonds=0;
    public int spades=0;
    public int clubs=0;
    
    public int bet=0;
    public int userTotal=0;
    public int dealerTotal=0;
    
    public BlackJack(){
        hearts=0;diamonds=0;spades=0;clubs=0;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    public int getSpades() {
        return spades;
    }

    public void setSpades(int spades) {
        this.spades = spades;
    }

    public int getClubs() {
        return clubs;
    }

    public void setClubs(int clubs) {
        this.clubs = clubs;
    }
    
    

public static void main(String[] args){
	BlackJack cc= new BlackJack();
	cc.Instructions();
        //cc.testing();
	

}

public void Instructions(){
    JOptionPane.showMessageDialog(null, "The object is to get a hand with a value as close to 21 as possible without going over. A hand that \n" +
"goes over 21 is a bust. The players at a blackjack table do not play against each other; they play \n" +
"against the dealer. Each player only has to beat the dealer's hand.");
    JDialog.setDefaultLookAndFeelDecorated(true);
    int response = JOptionPane.showConfirmDialog(null, "See instructions on how to play?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION) {
        System.out.println("_____________________Lets Play_____________________");
         placeBets();
    } else if (response == JOptionPane.YES_OPTION) {
      System.out.println("_____________________How to Play_____________________");
      System.out.println("");
      System.out.println("In blackjack, the suits have no meaning. Number cards have a value equal to their number,\n" +
"while all the picture cards (Jacks, Queens, and Kings) are worth 10. Aces can be worth 11 \n" +
"or one, whichever is more beneficial to the person holding the hand. \n\n" +
"Terminology : hard ace- worth one\n soft ace- worth 11\n bust- hand more than 21\n stand-placing down your cars to compare with dealer\n" +
              "push-tie (no one wins) player just gets his bet back");
       System.out.println("");
       System.out.println("After all bets have been placed, the dealer deals two cards to each player, \n" +
"the players' cards are dealt face down.The dealer then deals himself two cards -- \n" +
"one face up and one face down.");
       System.out.println("Each player in turn decides if his hand is close enough to 21 that it can beat\n" +
"the dealer's hand, based on the one dealer card he can see. If so, he stands.\n" +
"If the player wants to try to get closer to 21, he \n" +
"requests a hit, and the dealer deals him an additional card. If the player hasn't busted \n" +
"from the first hit, he gets to decide if he wants to be hit again or if he wants to stand. \n" );
        System.out.println("");
        System.out.println("Once you've made your play (bust or stand), the dealer reveals his second \n" +
"card ");
        System.out.println("If the dealer's\n" +
" total is 17 or higher, he has to stay. If his total is 16 or less, he has to hit. \n" +
" If the dealer busts, everyone at the table who didn't bust wins.");
        System.out.println("If the dealer doesn't bust, the dealer's hand is compared to each player's hand. The higher\n" +
"total wins, netting a 1-to-1 payoff for the player. A tie is a push -- the player gets his bet\n" +
" back, but wins nothing.\n" +
"\n" +
"Getting a blackjack (an Ace and a card worth 10 as your opening two cards) is like an instant\n" +
" win. It pays at 3 to 2, or one and a half times the original bet. The dealer can also get a \n" +
" blackjack, in which case everyone at the table loses. If both the dealer and a player get blackjack, it's a push.");
        int response2 = JOptionPane.showConfirmDialog(null, "Play?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response2 == JOptionPane.NO_OPTION){
            System.out.println("---Exited---");
            exit(0);
        }else if (response == JOptionPane.YES_OPTION){
            placeBets();
        }else if (response == JOptionPane.CLOSED_OPTION) {
          System.out.println("---Exited---");
    }
        
        
    } else if (response == JOptionPane.CLOSED_OPTION) {
      System.out.println("---Exited---");
    }

}

public void PlayGame(){
  // placeBets();
    //the random function counts twelve counts starting at 2 so it ends at 13
    //int userCard1=(int)(Math.random()*13) + 2; //returns a val in the range [0,13]... 13 is included . starts at 2 which is included. goes til 14 (14-2)=12 and 0 to 12 is 13
    setUpDeck();
      
    
}

public void testing(){
//    int arr[]=new int[14];
//    for (int j=0; j<14;j++){
//        arr[j]=j;
//    }
//    for (int i=0; i<14; i++){
//        System.out.println(arr[i]);
//    }
//    System.out.println(arr.length);
    String[] options = {"Hit", "Stand"};
    int choice = JOptionPane.showOptionDialog(null, "You really want to quit?", "Quit?", 
      JOptionPane.YES_NO_OPTION, 
      JOptionPane.QUESTION_MESSAGE, 
      null, 
      options, 
      options[0]);
    
    if (choice ==0){
        System.out.println("option o"); 
    }
    if (choice ==1){
        System.out.println("option 1");
    }

}

public int getSet(){
      //prints nums from 1 to 4 (1 and 4 included)
    /* 1=clubs
       2=diamonds
       3=hearts
       4=spades
    */
    
    int set=(int)(Math.random()*4)+1;
    
    return set;
}

public void placeBets(){
    Boolean correctBet=false;
    while(!correctBet){
           bet=Integer.parseInt(JOptionPane.showInputDialog(null, "Minimum bet to place is R20", "Enter amount in Rands e.g 50:"));
        if (bet <20){
        JOptionPane.showMessageDialog(null, "Invalid bet", "Bet is less than R20!",JOptionPane.ERROR_MESSAGE);
       }else{
            correctBet=true;
        }
    }
    PlayGame();
    
   
}
	
public void setUpDeck(){
        int userNum1=0; 
        int dealerNum1=0; 
        int userNum2=0; 
        int dealerNum2=0;
        
        Boolean success=false;
        
        BlackJack[] deck1;
        deck1 = new BlackJack[13];
	/*
	0=2
	1=3 
	2=4
	3=5
	4=6
	5=7
        6=8
        7=9
        8=10
        9=Jack
        10=Queen
        11=King
        12=Ace
	*/
        //studentArray[0] = new Student();
       
        //below initialise each element in obj array (which is null)
	for(int i=0; i<deck1.length; i++){
            
            deck1[i]=new BlackJack();
            
        }
        
        //after initialisation we can set it to values
        for(int j=0; j<deck1.length; j++){
            deck1[j].setClubs(j);
            deck1[j].setDiamonds(j);
            deck1[j].setHearts(j);
            deck1[j].setSpades(j);
        }
        
        //heres other code also-------------------------------
        
    
    
    
    String uCard=" ";
    String dCard=" ";
    Boolean anAce=false;
    String cSet=" ";
    
    int cNum=0;
    
       //prints nums from 1 to 4 (1 and 4 included)
    /* 1=clubs
       2=diamonds
       3=hearts
       4=spades
    */
    
    
    //2 3 4 5 6 7 8 9 10 j  q  k  a    the cards
    //2 3 4 5 6 7 8 9 10 11 12 13 14   their value when randomized
    //2 3 4 5 6 7 8 9 10 10 10 10 1/11 their actual value in blacjac
    
//card 1
    
   while(!success){
       anAce=false;
       int userCard1=(int)(Math.random()*13) + 2; 
       int sets=getSet();
    if (sets==1){
        cSet="Clubs";
    }if (sets==2){
        cSet="Diamonds";
    }if (sets==3){
        cSet="Hearts";
    }if (sets==4){
        cSet="Spades";
    }
    
       //System.out.println("userCard:::" + userCard1);
    
    if (userCard1==11 || userCard1==12 || userCard1==13 ){
       // userTotal=userTotal +10;
        if (userCard1==11){
            uCard="Jack"; cNum=9;//cNum reps position in array
        }else if (userCard1==12){
            uCard="Queen"; cNum=10;
        }else{
            uCard="King";cNum=11;
        }
        //JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
        
    }else if(userCard1==14){
        uCard="Ace";
        anAce=true;
        cNum=100;
       // JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
    }else{
        if (userCard1 <11){
            //userTotal=userTotal+userCard1;
            uCard=""+userCard1;
            cNum=userCard1-2;
            
        }
    }
       //System.out.println(cNum + " "+cSet );
    if (cNum !=100){
            if(cSet.equalsIgnoreCase("Diamonds")){
                if (deck1[cNum].getDiamonds() !=0){
                   deck1[cNum].setDiamonds(0); 
                   success=true;
                }
            }else if(cSet.equalsIgnoreCase("Hearts")){
                if(deck1[cNum].getHearts() !=0){
                    deck1[cNum].setHearts(0);
                    success=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                if(deck1[cNum].getClubs() !=0){
                    deck1[cNum].setClubs(0);
                    success=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Spades")){
                if (deck1[cNum].getSpades() !=0){
                    deck1[cNum].setSpades(0);
                    success=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }else{
        cNum=12;
            if(cSet.equalsIgnoreCase("Spades")){
                
                if (deck1[12].getSpades() !=0){
                    deck1[12].setSpades(0);
                    success=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Diamonds")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    success=true;
                }
                
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                
                if(deck1[12].getClubs() !=0){
                    deck1[12].setClubs(0);
                    success=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Hearts")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    success=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }
    
   }
   JOptionPane.showMessageDialog(null,"<<Your>> Card 1: " + uCard + " of " + cSet);
    System.out.println("\n\nUser\n card 1: " + uCard + " " + cSet);
    userNum1=cNum;
    
        
        //other code ends here---------------------------------
        
        
//card 2
   
   Boolean anAce2=false;Boolean success2=false;
   
   while(!success2){
       anAce2=false;
       int userCard2=(int)(Math.random()*13) + 2;
       int sets=getSet();
    if (sets==1){
        cSet="Clubs";
    }if (sets==2){
        cSet="Diamonds";
    }if (sets==3){
        cSet="Hearts";
    }if (sets==4){
        cSet="Spades";
    }
    
    
    
    if (userCard2==11 || userCard2==12 || userCard2==13 ){
        //userTotal=userTotal +10;
        if (userCard2==11){
            uCard="Jack"; cNum=9;
        }else if (userCard2==12){
            uCard="Queen"; cNum=10;
        }else{
            uCard="King";cNum=11;
        }
        //JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
        
    }else if(userCard2==14){
        uCard="Ace";
        anAce2=true;
        cNum=100;
       // JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
    }else{
        if (userCard2 <11){
            //userTotal=userTotal+userCard2;
            uCard=""+userCard2;
            cNum=userCard2-2;
            
        }
    }
       //System.out.println(cNum + " "+cSet );
    if (cNum !=100){
            if(cSet.equalsIgnoreCase("Diamonds")){
                if (deck1[cNum].getDiamonds() !=0){
                   deck1[cNum].setDiamonds(0); 
                   success2=true;
                }
            }else if(cSet.equalsIgnoreCase("Hearts")){
                if(deck1[cNum].getHearts() !=0){
                    deck1[cNum].setHearts(0);
                    success2=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                if(deck1[cNum].getClubs() !=0){
                    deck1[cNum].setClubs(0);
                    success2=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Spades")){
                if (deck1[cNum].getSpades() !=0){
                    deck1[cNum].setSpades(0);
                    success2=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }else{
        cNum=12;
            if(cSet.equalsIgnoreCase("Spades")){
                
                if (deck1[12].getSpades() !=0){
                    deck1[12].setSpades(0);
                    success2=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Diamonds")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    success2=true;
                }
                
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                
                if(deck1[12].getClubs() !=0){
                    deck1[12].setClubs(0);
                    success2=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Hearts")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    success2=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }
    
   }
   JOptionPane.showMessageDialog(null,"<<Your>> Card 2: " + uCard + " of " + cSet);
   System.out.println("\n\nUser\n card 2: " + uCard + " " + cSet);
   userNum2=cNum;
 
        
        
   Boolean dAce=false;Boolean success3=false;
   
   while(!success3){
       dAce=false;
       int dealerCard1=(int)(Math.random()*13) + 2;
       int sets=getSet();
    if (sets==1){
        cSet="Clubs";
    }if (sets==2){
        cSet="Diamonds";
    }if (sets==3){
        cSet="Hearts";
    }if (sets==4){
        cSet="Spades";
    }
    
    
    
    if (dealerCard1==11 || dealerCard1==12 || dealerCard1==13 ){
        //userTotal=userTotal +10;
        if (dealerCard1==11){
            uCard="Jack"; cNum=9;
        }else if (dealerCard1==12){
            uCard="Queen"; cNum=10;
        }else{
            uCard="King";cNum=11;
        }
        //JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
        
    }else if(dealerCard1==14){
        uCard="Ace";
        dAce=true;
        cNum=100;
       // JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
    }else{
        if (dealerCard1 <11){
            //userTotal=userTotal+dealerCard1;
            uCard=""+dealerCard1;
            cNum=dealerCard1-2;
            
        }
    }
       //System.out.println(cNum + " "+cSet );
    if (cNum !=100){
            if(cSet.equalsIgnoreCase("Diamonds")){
                if (deck1[cNum].getDiamonds() !=0){
                   deck1[cNum].setDiamonds(0); 
                   success3=true;
                }
            }else if(cSet.equalsIgnoreCase("Hearts")){
                if(deck1[cNum].getHearts() !=0){
                    deck1[cNum].setHearts(0);
                    success3=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                if(deck1[cNum].getClubs() !=0){
                    deck1[cNum].setClubs(0);
                    success3=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Spades")){
                if (deck1[cNum].getSpades() !=0){
                    deck1[cNum].setSpades(0);
                    success3=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }else{
        cNum=12;
            if(cSet.equalsIgnoreCase("Spades")){
                
                if (deck1[12].getSpades() !=0){
                    deck1[12].setSpades(0);
                    success3=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Diamonds")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    success3=true;
                }
                
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                
                if(deck1[12].getClubs() !=0){
                    deck1[12].setClubs(0);
                    success3=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Hearts")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    success3=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }
    
   }
   JOptionPane.showMessageDialog(null,"<<Dealer>> Card 1: " + uCard + " of " + cSet);
   System.out.println("\n\n Dealer \n Card 1: " + uCard + " " + cSet);
     dealerNum1=cNum;           
                
	
   
   Boolean dAce2=false; Boolean success4=false;
   
   while(!success4){
       dAce2=false;
       int dealerCard2=(int)(Math.random()*13) + 2;
       int sets=getSet();
    if (sets==1){
        cSet="Clubs";
    }if (sets==2){
        cSet="Diamonds";
    }if (sets==3){
        cSet="Hearts";
    }if (sets==4){
        cSet="Spades";
    }
    
    
    
    if (dealerCard2==11 || dealerCard2==12 || dealerCard2==13 ){
        //userTotal=userTotal +10;
        if (dealerCard2==11){
            uCard="Jack"; cNum=9;
        }else if (dealerCard2==12){
            uCard="Queen"; cNum=10;
        }else{
            uCard="King";cNum=11;
        }
        //JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
        
    }else if(dealerCard2==14){
        uCard="Ace";
        dAce2=true;
        cNum=100;
       // JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
    }else{
        if (dealerCard2 <11){
            //userTotal=userTotal+dealerCard2;
            uCard=""+dealerCard2;
            cNum=dealerCard2-2;
            
        }
    }
       //System.out.println(cNum + " "+cSet );
    if (cNum !=100){
            if(cSet.equalsIgnoreCase("Diamonds")){
                if (deck1[cNum].getDiamonds() !=0){
                   deck1[cNum].setDiamonds(0); 
                   success4=true;
                }
            }else if(cSet.equalsIgnoreCase("Hearts")){
                if(deck1[cNum].getHearts() !=0){
                    deck1[cNum].setHearts(0);
                    success4=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                if(deck1[cNum].getClubs() !=0){
                    deck1[cNum].setClubs(0);
                    success4=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Spades")){
                if (deck1[cNum].getSpades() !=0){
                    deck1[cNum].setSpades(0);
                    success4=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }else{
        cNum=12;
            if(cSet.equalsIgnoreCase("Spades")){
                
                if (deck1[12].getSpades() !=0){
                    deck1[12].setSpades(0);
                    success4=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Diamonds")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    success4=true;
                }
                
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                
                if(deck1[12].getClubs() !=0){
                    deck1[12].setClubs(0);
                    success4=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Hearts")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    success4=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }
    
    
   }
   System.out.println("\n\n Dealer \n Card 2: " + "???" + " " + "???");
   //JOptionPane.showMessageDialog(null,"<<Dealer>> Card 1: " + uCard + " of " + cSet);
   // System.out.println("\n\n Dealer \n Card 1: " + uCard + " " + cSet);
          //  System.out.println("card 2 of dealer: "+ uCard);
   dealerNum2=cNum;
   String dCard2=uCard;
   String dSet2=cSet;
   
    
          //  System.out.println("card 2 of dealer: "+ uCard);
 //  dealerNum2=cNum;
   
   
   Boolean blacJU=calcUserTotal(userNum1,userNum2, anAce, anAce2);
   
   Boolean blacJD=calcDealerTotal(dealerNum1,dealerNum2, dAce, dAce2);
    
    
   if (blacJU && blacJD){
       JOptionPane.showMessageDialog(null, "It's a push! No win\n You have recieved your R" +bet+ " initial bet");
   }
   if(blacJU && !blacJD){
       JOptionPane.showMessageDialog(null,"USER BLACKJACK!", "You've received R"+ (bet*1.5)+ " ", JOptionPane.INFORMATION_MESSAGE);
       exit(0);
   }
   if (blacJD && !blacJU){
       JOptionPane.showMessageDialog(null,"SYSTEM BLACKJACK!", "You've lost your bet\n Better luck next time" , JOptionPane.WARNING_MESSAGE);
       exit(0);
   }
   
   Boolean stand=false;Boolean dealerDone=false;
   Boolean uAce3=false; Boolean done=false;
   int c=2; int cd=2;
   
   while (!stand){
       
    
       
      String[] options = {"Stand", "Hit"};
    
      int choice = JOptionPane.showOptionDialog(null, "Stand or Hit?", "Time to choose?", 
      JOptionPane.YES_NO_OPTION, 
      JOptionPane.QUESTION_MESSAGE, 
      null, 
      options, 
      options[0]);
    
    if (choice ==0){
        //stand
        //System.out.println("code here still");
        stand=true;
        
        JOptionPane.showMessageDialog(null,"<<Dealer>> Card 2: " + dCard2 + " of " + dSet2);
        System.out.println("\n\n Dealer \n Card 2: " + dCard2 + " " + dSet2);
        if(dealerTotal >16){
            JOptionPane.showMessageDialog(null,"<<Dealer>> Card Total: " + dealerTotal);
            if(dealerTotal>userTotal){
       JOptionPane.showMessageDialog(null,"SYSTEM WIN!", "You've lost your bet\n Better luck next time" , JOptionPane.WARNING_MESSAGE);
       exit(0);
   }else if(userTotal>dealerTotal){
       JOptionPane.showMessageDialog(null,"USER WIN!", "You've received R"+ (bet*2), JOptionPane.INFORMATION_MESSAGE);
       exit(0);
   }else if(userTotal == dealerTotal){
       JOptionPane.showMessageDialog(null, "It's a push! No win\n You have recieved your R" +bet+ " initial bet");
       exit(0);
   }
        }else if(dealerTotal<17){
            cd++;
            //draw a card (hit) dealer has to hit
            Boolean dAce3=false;
            while (!dealerDone){
                dealerDone=false;
                
       int uCardAdd=(int)(Math.random()*13) + 2;
       int sets=getSet();
    if (sets==1){
        cSet="Clubs";
    }if (sets==2){
        cSet="Diamonds";
    }if (sets==3){
        cSet="Hearts";
    }if (sets==4){
        cSet="Spades";
    }
    
    if (uCardAdd==11 || uCardAdd==12 || uCardAdd==13 ){
       // userTotal=userTotal +10;
        if (uCardAdd==11){
            uCard="Jack"; cNum=9;
        }else if (uCardAdd==12){
            uCard="Queen"; cNum=10;
        }else{
            uCard="King";cNum=11;
        }
        //JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
        
    }else if(uCardAdd==14){
        uCard="Ace";
        dAce3=true;
        cNum=100;
       // JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
    }else{
        if (uCardAdd <11){
            //userTotal=userTotal+uCardAdd;
            uCard=""+uCardAdd;cNum=uCardAdd-2;
            
        }
    }
       //System.out.println(cNum + " "+cSet );
    if (cNum !=100){
            if(cSet.equalsIgnoreCase("Diamonds")){
                if (deck1[cNum].getDiamonds() !=0){
                   deck1[cNum].setDiamonds(0); 
                   dealerDone=true;
                }
            }else if(cSet.equalsIgnoreCase("Hearts")){
                if(deck1[cNum].getHearts() !=0){
                    deck1[cNum].setHearts(0);
                    dealerDone=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                if(deck1[cNum].getClubs() !=0){
                    deck1[cNum].setClubs(0);
                    dealerDone=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Spades")){
                if (deck1[cNum].getSpades() !=0){
                    deck1[cNum].setSpades(0);
                    dealerDone=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }else{
        cNum=12;
            if(cSet.equalsIgnoreCase("Spades")){
                
                if (deck1[12].getSpades() !=0){
                    deck1[12].setSpades(0);
                    dealerDone=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Diamonds")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    dealerDone=true;
                }
                
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                
                if(deck1[12].getClubs() !=0){
                    deck1[12].setClubs(0);
                    dealerDone=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Hearts")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    dealerDone=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }
                
            }
            
   JOptionPane.showMessageDialog(null,"<<Dealer>> Card "+cd+" : " + uCard + " of " + cSet);
   System.out.println("\n\n Dealer \n Card "+cd+" : " + uCard + " " + cSet);
   dealerNum1=cNum;
     
     //System.out.println("---dealer total is  "+dealerTotal);
   // blacJD=calcDealerTotal(cNum,dealerTotal, dAce3,false);
   dealerHitTotal(dAce3,cNum);
           
     /*if (blacJU && blacJD){
       JOptionPane.showMessageDialog(null, "It's a push! No win\n You have recieved your R" +bet+ "initial bet");
       exit(0);
   }
   if(blacJU && !blacJD){
       JOptionPane.showMessageDialog(null,"USER BLACKJACK!", "You've received R"+ (bet*2.5), JOptionPane.INFORMATION_MESSAGE);
       exit(0);
   }
   if (blacJD && !blacJU){
       JOptionPane.showMessageDialog(null,"SYSTEM BLACKJACK!", "You've lost your bet\n Better luck next time" , JOptionPane.WARNING_MESSAGE);
       exit(0);
   }*/
     
   JOptionPane.showMessageDialog(null, "User total: " +userTotal+ "\nSystem total: "+ dealerTotal);
      
   
   if(dealerTotal>userTotal){
       JOptionPane.showMessageDialog(null,"SYSTEM WIN!", "You've lost your bet\n Better luck next time" , JOptionPane.WARNING_MESSAGE);
       exit(0);
   }else if(userTotal>dealerTotal){
       JOptionPane.showMessageDialog(null,"USER WIN!", "You've received R"+ (bet*2), JOptionPane.INFORMATION_MESSAGE);
       exit(0);
   }else if(userTotal == dealerTotal){
       JOptionPane.showMessageDialog(null, "It's a push! No win\n You have recieved your R" +bet+ " initial bet");
       exit(0);
   }
   
        }
        
    }
    if (choice ==1){
        //hit (user hits)
        c++; 
        while (!done){
          
       done=false;     
       int uCardAdd=(int)(Math.random()*13) + 2;
       int sets=getSet();
    if (sets==1){
        cSet="Clubs";
    }if (sets==2){
        cSet="Diamonds";
    }if (sets==3){
        cSet="Hearts";
    }if (sets==4){
        cSet="Spades";
    }
    
    if (uCardAdd==11 || uCardAdd==12 || uCardAdd==13 ){
       // userTotal=userTotal +10;
        if (uCardAdd==11){
            uCard="Jack"; cNum=9;
        }else if (uCardAdd==12){
            uCard="Queen"; cNum=10;
        }else{
            uCard="King";cNum=11;
        }
        //JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
        
    }else if(uCardAdd==14){
        uCard="Ace";
        uAce3=true;
        cNum=100;
       // JOptionPane.showMessageDialog(null,"Card 1: " + uCard + " of " + cSet);
    }else{
        if (uCardAdd <11){
            //userTotal=userTotal+uCardAdd;
            uCard=""+uCardAdd;cNum=uCardAdd-2;
            
        }
    }
       //System.out.println(cNum + " "+cSet );
    if (cNum !=100){
            if(cSet.equalsIgnoreCase("Diamonds")){
                if (deck1[cNum].getDiamonds() !=0){
                   deck1[cNum].setDiamonds(0); 
                   done=true;
                }
            }else if(cSet.equalsIgnoreCase("Hearts")){
                if(deck1[cNum].getHearts() !=0){
                    deck1[cNum].setHearts(0);
                    done=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                if(deck1[cNum].getClubs() !=0){
                    deck1[cNum].setClubs(0);
                    done=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Spades")){
                if (deck1[cNum].getSpades() !=0){
                    deck1[cNum].setSpades(0);
                    done=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }else{
        cNum=12;
            if(cSet.equalsIgnoreCase("Spades")){
                
                if (deck1[12].getSpades() !=0){
                    deck1[12].setSpades(0);
                    done=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Diamonds")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    done=true;
                }
                
                
            }else if(cSet.equalsIgnoreCase("Clubs")){
                
                if(deck1[12].getClubs() !=0){
                    deck1[12].setClubs(0);
                    done=true;
                }
                
            }else if(cSet.equalsIgnoreCase("Hearts")){
                
                if(deck1[12].getHearts() !=0){
                    deck1[12].setHearts(0);
                    done=true;
                }
                
            }else{
                System.out.println("error in setUpDeck()");
                exit(0);
            }
        }
            
        }
       
    
    
    JOptionPane.showMessageDialog(null,"<<User>> Card "+c+" : " + uCard + " of " + cSet);
    System.out.println("\n\n User \n Card "+c+" : " + uCard + " " + cSet);
     dealerNum1=cNum;
    
    //blacJU=calcUserTotal(cNum,userTotal, uAce3,false);
    userHitTotal(uAce3,cNum);
    stand=false;
     
    /* if (blacJU && blacJD){
       JOptionPane.showMessageDialog(null, "It's a push! No win\n You have recieved your R" +bet+ "initial bet");
       exit(0);
     }
   if(blacJU && !blacJD){
       JOptionPane.showMessageDialog(null,"USER BLACKJACK!", "You've received R"+ (bet*2.5), JOptionPane.INFORMATION_MESSAGE);
       exit(0);
   }
   if (blacJD && !blacJU){
       JOptionPane.showMessageDialog(null,"SYSTEM BLACKJACK!", "You've lost your bet\n Better luck next time" , JOptionPane.WARNING_MESSAGE);
       exit(0);
   }*/
   
   
    }
    
    
   }
   
   
   
   
   
   
     //dealer dealt cards y
   
   
    //check if user==blacjac or user==busts
   //if anAce ==true present options y
   /*
	0=2
	1=3 
	2=4
	3=5
	4=6
	5=7
        6=8
        7=9
        8=10
        9=Jack
        10=Queen
        11=King
        12=Ace
	*/
   
     
   
   //ask user if hit or stand?
   
   
   
   
	}

public Boolean calcUserTotal(int card1, int card2, Boolean ace1, Boolean ace2){//positions in arr
//    System.out.println("card 1::" +card1);
//    System.out.println("card 2::" +card2);
//  System.out.println("in calc user total : (array posn) card1__ " + card1);
//  System.out.println("in calc user total : (array posn) card2__ " + card2);
    
   int aceValue=0;
   int usersCards=0;
   
   Boolean blacjac=false;
   Boolean bust=false;
   
//   System.out.println("card 1 is "+ card1);
//   System.out.println("card 2 is "+ card2);
   
   if (ace1){
       aceValue=aceValue+ (Integer.parseInt(JOptionPane.showInputDialog(null, "ACE VALUE", "Enter a 1 or 11 to be used as your ace's value:")));
   }
   if (ace2){
       aceValue=aceValue+ (Integer.parseInt(JOptionPane.showInputDialog(null, "ACE VALUE", "Enter a 1 or 11 to be used as your ace's value:")));
      // System.out.println("asks again");
   }
   
   usersCards=usersCards+aceValue;
    //System.out.println("user card total::"+ usersCards);
   
   if (card1 <9){
       usersCards=usersCards+(card1+2);
   }else if (card1 == 9 || card1 == 10 ||card1 == 11  ){
       
           usersCards=usersCards+10;
       
       
   }
   
    //System.out.println("users cards total::"+ usersCards);
   
   
   
   if (card2 <9){
       usersCards=usersCards+(card2+2);
   }else if (card2 == 9 || card2 == 10 ||card2 == 11  ){
       
           usersCards=usersCards+10;
       
   }
   
   userTotal=userTotal+usersCards;
   
    // System.out.println("users cards total::"+ usersCards);
   
   if(usersCards>21){
       bust=true;
   }
   if (ace1  || ace2){
      if(usersCards==21){
          blacjac=true;
      } 
   }
    
   //System.out.println("user card total: "+ usersCards);
   if (bust){
       System.out.println("USER CARD TOTAL: "+ usersCards);
       JOptionPane.showMessageDialog(null,"SYSTEM WIN!", "You've lost your bet.\n Better luck next time" , JOptionPane.WARNING_MESSAGE);
       exit(0);
   }
   userTotal=usersCards;
    return blacjac;
}



public Boolean calcDealerTotal(int card1, int card2, Boolean ace1, Boolean ace2){
   Boolean blacjac=false;
   Boolean bust=false;
    
    
   int aceValue=0;
   int dCards=0;
   
   
   //System.out.println("-card1- in method- "+card1);
   if (card1 <9){
       dCards=dCards+(card1+2);
   }else if (card1 == 9|| card1 == 10|| card1 == 11){
       dCards=dCards+10;
       
   }
    
   if (card2 <9){
       dCards=dCards+(card2+2);
   }else if (card2 == 9|| card2 == 10|| card2 == 11){
       dCards=dCards+10;
       
   }
   
  
  
  
       
   
   //System.out.println("____________________"+card2);
   
   dealerTotal=dealerTotal+dCards;
   
   if (ace1 && !ace2){
       if(dCards<11 ){
              aceValue=11;
          } 
       else{
           aceValue=1;
       }
     }
   if (ace2 && !ace1){
      if(dCards<11 ){
              aceValue=11;
          } 
       else{
           aceValue=1;
       }
   }
   if (ace1 && ace2){
       aceValue=11+1;
   }
   
   dCards=dCards+aceValue;
   
   
   
   
   // System.out.println("dealer total::"+ dCards);
   
   if (bust){
       System.out.println("SYSTEM CARD TOTAL: "+ dCards);
       JOptionPane.showMessageDialog(null,"USER WIN!", "System busts. You get R"+(bet*2) , JOptionPane.WARNING_MESSAGE);
       exit(0);
   }
   
   dealerTotal=dCards;
    return blacjac;
    
   
}

public void dealerHitTotal(Boolean ace, int deckPos){
    if (deckPos < 9){
        dealerTotal=dealerTotal +deckPos+2;
    }else if (deckPos==9 || deckPos==10 || deckPos==11){
        dealerTotal=dealerTotal+10;
    }else{
        if ( ace ){
            if(dealerTotal < 11){
                dealerTotal=dealerTotal +11;
            }else{
                dealerTotal=dealerTotal+1;
            }
        }
    }
    if (dealerTotal > 21){
        JOptionPane.showMessageDialog(null,"USER WIN!", "You've received R"+ (bet*2), JOptionPane.INFORMATION_MESSAGE);
        exit(0);
    }
}

public void userHitTotal(Boolean ace, int deckPos){
    int aval=0;
    if (deckPos < 9){
        userTotal=userTotal +deckPos+2;
    }else if (deckPos==9 || deckPos==10 || deckPos==11){
        userTotal=userTotal+10;
    }else{
        if ( ace ){
            JOptionPane.showMessageDialog(null,"USER Total", "Your total thus far: "+ userTotal , JOptionPane.INFORMATION_MESSAGE);
            aval=aval+ (Integer.parseInt(JOptionPane.showInputDialog(null, "ACE VALUE", "Enter a 1 or 11 to be used as your ace's value:")));
            userTotal=userTotal+aval;
        }
    }
    if (userTotal >21){
       JOptionPane.showMessageDialog(null,"SYSTEM WIN!", "You've lost your bet.\n Better luck next time" , JOptionPane.WARNING_MESSAGE);
       exit(0);
    }
    
}

}
