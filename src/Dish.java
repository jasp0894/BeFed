import java.util.Random;




public class Dish {

	private Side puertoRican[][];
	private int row, column;
	private int n;
	private int clickedRow;
	private int clickedCol; 
	

	public Dish(int n){
		this.n = n;
		puertoRican = new Side[n][n];
		for (int i = 0; i < puertoRican.length; i++) {
			for (int j = 0; j < puertoRican.length; j++) {
				puertoRican[i][j] = randSide(i,j);
			}
		}
	}
	public Side randSide(int row,int col){
		Random rand = new Random(); 
		int tileNum = rand.nextInt(Side.sideTaste.values().length);
		Side side = new Side(Side.sideTaste.values()[tileNum],row,col, n);
		return side;
	}

	public Side getPuertoRican(int row, int column) {
		return puertoRican[row][column];
	}
	public void setPuertoRican(Side[][] puertoRican) {
		this.puertoRican = puertoRican;
	}
	
	public void foodClicked(int x, int y){
		setRowClicked(y);
		setColClicked(x);
	}
	public void setRowClicked(int y){
		for(int i=0; i<n;i++){
			if((double) y/(Side.n*Side.size+ 4) > (double)i/n && (double) y/(Side.n*Side.size+ 4)< (double) (i+1)/n){
				this.clickedRow=i;
				}
		}
		
	}
	public void setColClicked(int x){
		
		for(int j=0; j<n;j++){
			if((double) x/(Side.n*Side.size+ 4) > (double)j/n && (double) x/(Side.n*Side.size+ 4)< (double) (j+1)/n){
				this.clickedCol=j;
				
			}
		}
		
	}
	public int getClickedRow(){
		return clickedRow;
	}
	public int getClickedCol(){
		return clickedCol;
	}
	//para invocar en el, el metodo setFocus o isFocus de Side.java
	public Side getClickedPuertoRican(){
		return getPuertoRican(clickedRow,clickedCol);
		
	}
	
	
	
// metodos para lograr el swap, no se si deban ir aqui o en una clase aparte como Algorithms.java
	
	
	private boolean horizontalMove=false;
	private boolean verticalMove=false;
	private int rowFocus=0, colFocus=0;
	//para el segundo click; verifica si ya habia uno identificado(hay que identificarlo) en esa fila
	public boolean isColFocused(){
		int i=clickedRow;//x fixed coor.
		boolean flag=false;
		for(int j=0; j<Side.n; j++){
			if(puertoRican[i][j].isFocus()){
				this.rowFocus=i;//x fixed coor.
				this.colFocus=j;//y coor.
				this.verticalMove=true;
				flag=true;
			}
		}
		return flag;
		
	}
	//para el segundo click; verifica si a habia uno identificado en esa fila
	public boolean isRowFocused(){
		int j=clickedCol;//y fixed coordinate
		boolean flag=false;
		for(int i=0; i<Side.n; i++){
			if(puertoRican[i][j].isFocus()){
				this.rowFocus=i;//x coor.
				this.colFocus=j;//y fixed coor.
				this.horizontalMove=true;
				flag=true;
			}
		}
		return flag;
		
		
	}
	public boolean isAnyoneFocus(){
		if(isRowFocused()||isColFocused()){
			return true;
		}else return false;
	}
	public boolean isMovementPossible(){
		boolean flag=false;
		if(isAnyoneFocus()){
			if(this.horizontalMove){
				if(Math.abs(clickedRow-rowFocus)==1){
					flag=true;
				}
			}else if(this.verticalMove){
				if(Math.abs(clickedCol-colFocus)==1){
					flag=true;
				}
			}
			return flag;
		}else
			return flag;
	}
	//si el moviemiento no  es posible, o en esa fila y columna no hay nadie mas focus, entonces
	//coloca en Focus la comida seleccionada
	// y le quita el Focus a la que ya lo tenia
	
	public void setNewFocus(){
		if(!isMovementPossible()){
			this.puertoRican[rowFocus][colFocus].setFocus(false);
			this.puertoRican[clickedRow][clickedCol].setFocus(true);
		}
	}
		
	//metodos booleanos para las condiciones de verificacion
	public boolean isRightUpperCorner(int row, int col){
		if(row == 0 && col== (Side.n-1))
			return true;
		else return false;
			
	}
	public boolean isRightLowerCorner(int row, int col){
		if(row== (Side.n-1) && col==(Side.n-1))
			return true;
		else return false;
	}

	public boolean isLeftUpperCorner(int row, int col){
		if(row == 0 && col== 0)
			return true;
		else return false;
	}
	
	public boolean isLeftLowerCorner(int row, int col){
		if(row == (Side.n-1) && col== 0)
			return true;
		else return false;
	}
	public boolean isFirstRow(int row){
		if(row==0)
			return true;
		else return false;
		
	}
	public boolean isLastRow(int row){
		if(row==(Side.n-1))
			return true;
		else return false;
		
	}
	public boolean isFirstCol(int col){
		if(col==0)
			return true;
		else return false;
		
	}
	public boolean isLastCol(int col){
		if(col==(Side.n-1))
			return true;
		else return false;
		
	}/*
	public void check(int row, int col){
		if(isFirstRow(row) && isLeftUpperCorner(row,col)){
			checkBelow(row,col);
			checkRightSide(row,col);
		}else if(isFirstRow(row) && isRightUpperCorner(row,col)){
			checkBelow(row,col);
			checkLeftSide(row,col);
		}else if(isFirstRow(row)){
			checkBelow(row,col);
			checkRightSide(row,col);
			checkLeftSide(row,col);
		//first row cases	
		}else if(isFirstCol(col)&& isLeftUpperCorner(row,col)){
			checkBelow(row,col);
			checkRightSide(row,col);
		}else if(isFirstCol(col)&& isLeftLowerCorner(row,col)){
			checkAbove(row,col);
			checkRightSide(row,col);
		}else if(isFirstCol(col)){
			checkAbove(row,col);
			checkBelow(row,col);
			checkRightSide(row,col);
		//first column cases	
		}else if(isLastRow(row) && isLeftLowerCorner(row,col)){
			checkAbove(row,col);
			checkRightSide(row,col);
		}else if(isLastRow(row) && isRightLowerCorner(row,col)){
			checkAbove(row,col);
			checkLeftSide(row,col);
		}else if(isLastRow(row)){
			checkAbove(row,col);
			checkRightSide(row,col);
			checkLeftSide(row,col);
		//last row cases	
		}else if(isLastCol(col) && isRightUpperCorner(row,col)){
			checkLeftSide(row,col);
			checkBelow(row,col);
		}else if(isLastCol(col) && isRightLowerCorner(row,col)){
			checkLeftSide(row,col);
			checkAbove(row,col);
		}else if(isLastCol(col)){
			checkLeftSide(row,col);
			checkBelow(row,col);
			checkAbove(row,col);
		
		//last column cases
		}else{
			checkRightSide(row,col);
			checkLeftSide(row,col);
			checkBelow(row,col);
			checkAbove(row,col);
		//any other position	
		}
	}*/
	public Side[] checkAbove(int row, int col ){//no va a ser void, va a devolver un array de enteros
		Side[] side= new Side[10];
		int index=0;
		String myId=getPuertoRican(row,col).getID();
		int j=col;
		
		for(int i=(row-1);i>=0; i--){
			if(getPuertoRican(i,j).getID().equals(myId)){
				//falta lo de coleccionar los repetidos
			side[index]=getPuertoRican(i,j);
			index++;
			}else break;
		}
		
		return side;
		
	}
	public void checkBelow(int row, int col){//no va a ser void, va a dovolver un array de enteros
		String myId=getPuertoRican(row,col).getID();
		int j=col;
		for(int i=(row+1);i<Side.n; i++){
			if(getPuertoRican(i,j).getID().equals(myId)){
				//falta lo de coleccionar los repetidos
			}else break;
		}
		
	}
	public void checkLeftSide(int row, int col){//no va a ser void, va a dovolver un array de enteros
		String myId=getPuertoRican(row,col).getID();
		int i=row;
		for(int j=(col-1);j>=0; j--){
			if(getPuertoRican(i,j).getID().equals(myId)){
				//falta lo de coleccionar los repetidos
			}else break;
		}
		
	}
	public void checkRightSide(int row, int col){//no va a ser void, va a dovolver un array de enteros
		String myId=getPuertoRican(row,col).getID();
		int i=row;
		for(int j=(col+1);j<Side.n; j++){
			if(getPuertoRican(i,j).getID().equals(myId)){
				//falta lo de coleccionar los repetidos
			}else break;
		}
		
		
		
	}
}
	//faltan metodos como moveUp y moveDown.... tal vez el swap deba ser algo asi como
	//verificar si el moviento es para arriba-abajo y entonces invocar a los metodos moveUp, Down..etc
	/*
	public void swap(int row, int col, int toRow, int toCol){
		Side changedSide=null;
		changedSide=puertoRican[row][col];
		puertoRican[row][col]=puertoRican[toRow][toCol];
		puertoRican[toRow][toCol]=changedSide;
		//aqui debe ir el timer 
		
	}
	public void undoSwap(){
		swap(rowFocus,colFocus,clickedRow,clickedCol);
	}
	*/

