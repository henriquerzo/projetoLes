package com.example.logica;

import java.util.ArrayList;
import java.util.Random;

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
		campo = novoCampo();
	}
	
	public int[][] novoCampo(){
		ArrayList<int[][]> campos = new ArrayList<int[][]>();
		
		campos.add(new int[][] {{1, 2, 4, 3 }, {5, 6, 8, 7},
				{9, 11, 10, 12}, {13, 15, 14, 0}});
		
		campos.add(new int[][] {{2, 1, 4, 3 }, {6, 5, 8, 7},
				{9, 11, 10, 12}, {13, 15, 0, 14}});
		
		campos.add(new int[][] {{0, 2, 4, 3 }, {5, 6, 8, 7},
				{9, 11, 10, 12}, {13, 15, 14, 1}});
		
		campos.add(new int[][] {{1, 2, 4, 3 }, {5, 6, 8, 7},
				{0, 11, 10, 12}, {13, 15, 14, 9}});
		
		campos.add(new int[][] {{4, 2, 1, 3 }, {0, 6, 8, 12},
				{9, 11, 10, 7}, {13, 15, 14, 5}});

		
		Random random = new Random();
		return campos.get(random.nextInt(campos.size()));
	}

	public boolean completo(){
		if(campo[0][0]==1 && campo[0][1]==2 && campo[0][2]==3 && campo[0][3]==4 && campo[1][0]==5 && campo[1][1]==6 && campo[1][2]==7 && campo[1][3]==8 && campo[2][0]==9 && campo[2][1]==10 && campo[2][2]==11 && campo[2][3]==12 && campo[3][0]==13 && campo[3][1]==14 && campo[3][2]==15 && campo[3][3]==0){
			return true;
		}else{
			return false;
		}
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
		    if(posicaoX==0 && posicaoY==0){
		    	if(campo[1][0]==0){
			    	temp = campo[0][0];
			    	campo[0][0] = 0;
			    	campo[1][0] = temp;
			    }else if(campo[0][1]==0){
			    	temp = campo[0][0];
			    	campo[0][0] = 0;
			    	campo[0][1] = temp;
			    }else{
			    	return false;
			    }
		    }else if(posicaoX==1 && posicaoY==0){
		    	if(campo[0][0]==0){
			    	temp = campo[1][0];
			    	campo[1][0] = 0;
			    	campo[0][0] = temp;
			    }else if(campo[2][0]==0){
			    	temp = campo[1][0];
			    	campo[1][0] = 0;
			    	campo[2][0] = temp;
			    }else if(campo[1][1]==0){
			    	temp = campo[1][0];
			    	campo[1][0] = 0;
			    	campo[1][1] = temp;
			    }else{
			    	return false;
			    }
		    }else if(posicaoX==2 && posicaoY==0){
		    	if(campo[1][0]==0){
		    		temp = campo[2][0];
			    	campo[2][0] = 0;
			    	campo[1][0] = temp;
		    	}else if(campo[2][1]==0){
		    		temp = campo[2][0];
			    	campo[2][0] = 0;
			    	campo[2][1] = temp;
		    	}else if(campo[3][0]==0){
		    		temp = campo[2][0];
			    	campo[2][0] = 0;
			    	campo[3][0] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==3 && posicaoY==0){
		    	if(campo[2][0]==0){
		    		temp = campo[3][0];
			    	campo[3][0] = 0;
			    	campo[2][0] = temp;
		    	}else if(campo[3][1]==0){
		    		temp = campo[3][0];
			    	campo[3][0] = 0;
			    	campo[3][1] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==0 && posicaoY==1){
		    	if(campo[0][0]==0){
		    		temp = campo[0][1];
			    	campo[0][1] = 0;
			    	campo[0][0] = temp;
		    	}else if(campo[1][1]==0){
		    		temp = campo[0][1];
			    	campo[0][1] = 0;
			    	campo[1][1] = temp;
		    	}else if(campo[0][2]==0){
		    		temp = campo[0][1];
			    	campo[0][1] = 0;
			    	campo[0][2] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==1 && posicaoY==1){
		    	if(campo[0][1]==0){
		    		temp = campo[1][1];
			    	campo[1][1] = 0;
			    	campo[0][1] = temp;
		    	}else if(campo[1][0]==0){
		    		temp = campo[1][1];
			    	campo[1][1] = 0;
			    	campo[1][0] = temp;
		    	}else if(campo[2][1]==0){
		    		temp = campo[1][1];
			    	campo[1][1] = 0;
			    	campo[2][1] = temp;
		    	}else if(campo[1][2]==0){
		    		temp = campo[1][1];
			    	campo[1][1] = 0;
			    	campo[1][2] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==2 && posicaoY==1){
		    	if(campo[1][1]==0){
		    		temp = campo[2][1];
			    	campo[2][1] = 0;
			    	campo[1][1] = temp;
		    	}else if(campo[2][0]==0){
		    		temp = campo[2][1];
			    	campo[2][1] = 0;
			    	campo[2][0] = temp;
		    	}else if(campo[3][1]==0){
		    		temp = campo[2][1];
			    	campo[2][1] = 0;
			    	campo[3][1] = temp;
		    	}else if(campo[2][2]==0){
		    		temp = campo[2][1];
			    	campo[2][1] = 0;
			    	campo[2][2] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==3 && posicaoY==1){
		    	if(campo[2][1]==0){
		    		temp = campo[3][1];
			    	campo[3][1] = 0;
			    	campo[2][1] = temp;
		    	}else if(campo[3][0]==0){
		    		temp = campo[3][1];
			    	campo[3][1] = 0;
			    	campo[3][0] = temp;
		    	}else if(campo[3][2]==0){
		    		temp = campo[3][1];
			    	campo[3][1] = 0;
			    	campo[3][2] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==0 && posicaoY==2){
		    	if(campo[0][1]==0){
		    		temp = campo[0][2];
			    	campo[0][2] = 0;
			    	campo[0][1] = temp;
		    	}else if(campo[1][2]==0){
		    		temp = campo[0][2];
			    	campo[0][2] = 0;
			    	campo[1][2] = temp;
		    	}else if(campo[0][3]==0){
		    		temp = campo[0][2];
			    	campo[0][2] = 0;
			    	campo[0][3] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==1 && posicaoY==2){
		    	if(campo[0][2]==0){
		    		temp = campo[1][2];
			    	campo[1][2] = 0;
			    	campo[0][2] = temp;
		    	}else if(campo[1][1]==0){
		    		temp = campo[1][2];
			    	campo[1][2] = 0;
			    	campo[1][1] = temp;
		    	}else if(campo[2][2]==0){
		    		temp = campo[1][2];
			    	campo[1][2] = 0;
			    	campo[2][2] = temp;
		    	}else if(campo[1][3]==0){
		    		temp = campo[1][2];
			    	campo[1][2] = 0;
			    	campo[1][3] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==2 && posicaoY==2){
		    	if(campo[1][2]==0){
		    		temp = campo[2][2];
			    	campo[2][2] = 0;
			    	campo[1][2] = temp;
		    	}else if(campo[2][1]==0){
		    		temp = campo[2][2];
			    	campo[2][2] = 0;
			    	campo[2][1] = temp;
		    	}else if(campo[3][2]==0){
		    		temp = campo[2][2];
			    	campo[2][2] = 0;
			    	campo[3][2] = temp;
		    	}else if(campo[2][3]==0){
		    		temp = campo[2][2];
			    	campo[2][2] = 0;
			    	campo[2][3] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==3 && posicaoY==2){
		    	if(campo[2][2]==0){
		    		temp = campo[3][2];
			    	campo[3][2] = 0;
			    	campo[2][2] = temp;
		    	}else if(campo[3][1]==0){
		    		temp = campo[3][2];
			    	campo[3][2] = 0;
			    	campo[3][1] = temp;
		    	}else if(campo[3][3]==0){
		    		temp = campo[3][2];
			    	campo[3][2] = 0;
			    	campo[3][3] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==0 && posicaoY==3){
		    	if(campo[0][2]==0){
		    		temp = campo[0][3];
			    	campo[0][3] = 0;
			    	campo[0][2] = temp;
		    	}else if(campo[1][3]==0){
		    		temp = campo[0][3];
			    	campo[0][3] = 0;
			    	campo[1][3] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==1 && posicaoY==3){
		    	if(campo[0][3]==0){
		    		temp = campo[1][3];
			    	campo[1][3] = 0;
			    	campo[0][3] = temp;
		    	}else if(campo[1][2]==0){
		    		temp = campo[1][3];
			    	campo[1][3] = 0;
			    	campo[1][2] = temp;
		    	}else if(campo[2][3]==0){
		    		temp = campo[1][3];
			    	campo[1][3] = 0;
			    	campo[2][3] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==2 && posicaoY==3){
		    	if(campo[1][3]==0){
		    		temp = campo[2][3];
			    	campo[2][3] = 0;
			    	campo[1][3] = temp;
		    	}else if(campo[2][2]==0){
		    		temp = campo[2][3];
			    	campo[2][3] = 0;
			    	campo[2][2] = temp;
		    	}else if(campo[3][3]==0){
		    		temp = campo[2][3];
			    	campo[2][3] = 0;
			    	campo[3][3] = temp;
		    	}else{
		    		return false;
		    	}
		    }else{
		    	if(campo[2][3]==0){
		    		temp = campo[3][3];
			    	campo[3][3] = 0;
			    	campo[2][3] = temp;
		    	}else if(campo[3][2]==0){
		    		temp = campo[3][3];
			    	campo[3][3] = 0;
			    	campo[3][2] = temp;
		    	}else{
		    		return false;
		    	}
		    }	
		}
		return true;
	}

}
