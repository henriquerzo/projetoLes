package com.example.logica;

public class Matriz {

	private static Matriz matriz;
	private int[][] campo;
	
	public static Matriz getInstance(){
		if(matriz==null){
			matriz = new Matriz();
		}
		return matriz;
	}
	
	private Matriz(){
		campo = new int[][] {{2,4,3},{1,6,8},{7,5,0}};
	}
	
	public boolean movimentar(int posicaoX, int posicaoY){
		if(campo[posicaoX][posicaoY]==0){
			return false;
		}else{
			int temp;
		    if(posicaoX==0 && campo[1][posicaoY]==0){
		    	temp = campo[0][posicaoY];
		    	campo[0][posicaoY] = 0;
		    	campo[1][posicaoY] = temp;
		    }else if(posicaoX==2 && campo[1][posicaoY]==0){
		    	temp = campo[2][posicaoY];
		    	campo[2][posicaoY] = 0;
		    	campo[1][posicaoY] = temp;
		    }else if(posicaoY==0 && campo[posicaoX][1]==0){
		    	temp = campo[posicaoX][0];
		    	campo[posicaoX][0] = 0;
		    	campo[posicaoX][1] = temp;
		    }else if(posicaoY==2 && campo[posicaoX][1]==0){
		    	temp = campo[posicaoX][2];
		    	campo[posicaoX][2] = 0;
		    	campo[posicaoX][1] = temp;
		    }else if(posicaoX==0 && posicaoY==1){
		    	temp = campo[0][1];
		    	if(campo[0][0]==0){
		    		campo[0][1] = 0;
		    		campo[0][0] = temp;
		    	}
		    	else if(campo[0][2]==0){
		    		campo[0][1] = 0;
		    		campo[0][2] = temp;
		    	}
		    	else if(campo[1][1]==0){
		    		campo[0][1] = 0;
		    		campo[1][1] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==2 && posicaoY == 1){
		    	temp = campo[2][1];
		    	if(campo[2][0]==0){
		    		campo[2][1] = 0;
		    		campo[2][0] = temp;
		    	}
		    	else if(campo[2][2]==0){
		    		campo[2][1] = 0;
		    		campo[2][2] = temp;
		    	}
		    	else if(campo[1][1]==0){
		    		campo[2][1] = 0;
		    		campo[1][1] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==1 && posicaoY==0){
		    	temp = campo[1][0];
		    	if(campo[0][0]==0){
		    		campo[1][0] = 0;
		    		campo[0][0] = temp;
		    	}
		    	else if(campo[2][0]==0){
		    		campo[1][0] = 0;
		    		campo[2][0] = temp;
		    	}
		    	else if(campo[1][1]==0){
		    		campo[1][0] = 0;
		    		campo[1][1] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==1 && posicaoY==2){
		    	temp = campo[1][2];
		    	if(campo[0][2]==0){
		    		campo[1][2]=0;
		    		campo[0][2]=temp;
		    	}
		    	else if(campo[2][2]==0){
		    		campo[1][2]=0;
		    		campo[2][2]=temp;
		    	}
		    	else if(campo[1][1]==0){
		    		campo[1][2]=0;
		    		campo[1][1]=temp;
		    	}else{
		    		return false;
		    	}
		    }else{
		    	temp = campo[1][1];
		    	if(campo[1][0]==0){
		    		campo[1][1]=0;
		    		campo[1][0]=temp;
		    	}
		    	else if(campo[0][1]==0){
		    		campo[1][1]=0;
		    		campo[0][1]=temp;
		    	}
		    	else if(campo[2][1]==0){
		    		campo[1][1]=0;
		    		campo[2][1]=temp;
		    	}
		    	else if(campo[1][2]==0){
		    		campo[1][1]=0;
		    		campo[1][2]=temp;
		    	}else{
		    		return false;
		    	}
		    } 	
		}
		return true;
	}
	
	public int[][] getCampo(){
		return campo;
	}
	
	public void reset(){
		campo = new int[][] {{2,4,3},{1,6,8},{7,5,0}};
	}
	
	public boolean completo(){
		if(campo[0][0]==1 && campo[0][1]==2 && campo[0][2]==3 && campo[1][0]==4 && campo[1][1]==5 && campo[1][2]==6 && campo[2][0]==7 && campo[2][1]==8 && campo[2][2]==0){
			return true;
		}else{
			return false;
		}
	}
}
