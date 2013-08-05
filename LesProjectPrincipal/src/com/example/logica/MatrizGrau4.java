package com.example.logica;

public class MatrizGrau4 {

	private static MatrizGrau4 matriz;
	private int[][] campo;

	private MatrizGrau4() {

		campo = new int[][] { { 1, 2, 4, 3 }, { 5, 6, 8, 7 },
				{ 9, 11, 10, 12 }, { 13, 15, 14, 0 } };
	}

	public static MatrizGrau4 getInstance() {

		if (matriz == null) {
			matriz = new MatrizGrau4();
		}
		return matriz;

	}

	public void reset() {
		campo = new int[][] { { 1, 2, 4, 3 }, { 5, 6, 8, 7 },
				{ 9, 11, 10, 12 }, { 13, 15, 14, 0 } };
	}

	public boolean completo() {
		return false;
	}

	public int[][] getCampo() {
		// TODO Auto-generated method stub
		return campo;
	}

	public boolean movimentar(int posicaoX, int posicaoY) {
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
		    	if(posicaoX==1 && posicaoY==1){
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
		}
		return true;
	}

}
