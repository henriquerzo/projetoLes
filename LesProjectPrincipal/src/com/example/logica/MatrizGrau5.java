package com.example.logica;

import java.util.ArrayList;
import java.util.Random;

public class MatrizGrau5 {

	private static MatrizGrau5 matriz;
	private int[][] campo;

	private MatrizGrau5() {

		campo = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, {21, 22, 23, 0, 24} };
	}

	public static MatrizGrau5 getInstance() {

		if (matriz == null) {
			matriz = new MatrizGrau5();
		}
		return matriz;

	}

	public void reset() {
		campo = novoCampo();
	}
	
	
	public int[][] novoCampo(){
		
		ArrayList<int[][]> campos = new ArrayList<int[][]>();
		
		campos.add(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, {21, 22, 23, 0, 24} });
		campos.add(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, {21, 22, 0, 23, 24} });
		
		campos.add(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, {21, 0, 22, 23, 24} });
		campos.add(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, {0, 21, 22, 23, 24} });
		campos.add(new int[][] { { 0, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, {21, 1, 22, 23, 24} });
		
		Random random = new Random();
		return campos.get(random.nextInt(campos.size()));
	}

	public boolean completo() {
		if(campo[0][0]==1 && campo[0][1]==2 && campo[0][2]==3 && campo[0][3]==4 && campo[0][4]==5 && campo[1][0]==6 && campo[1][1]==7 && campo[1][2]==8 && campo[1][3]==9 && campo[1][4]==10 && campo[2][0]==11 && campo[2][1]==12 && campo[2][2]==13 && campo[2][3]==14 && campo[2][4]==15 && campo[3][0]==16 && campo[3][1]==17 && campo[3][2]==18 && campo[3][3]==19 && campo[3][4]==20 && campo[4][0]==21 && campo[4][1]==22 && campo[4][2]==23 && campo[4][3]==24 && campo[4][4]==0){
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
		    	}else if(campo[4][0]==0){
		    		temp = campo[3][0];
			    	campo[3][0] = 0;
			    	campo[4][0] = temp;
		    	}
		    	else{
		    		return false;
		    	}
		    }else if(posicaoX==4 && posicaoY==0){
		    	if(campo[3][0]==0){
		    		temp = campo[4][0];
			    	campo[4][0] = 0;
			    	campo[3][0] = temp;
		    	}else if(campo[4][1]==0){
		    		temp = campo[4][0];
			    	campo[4][0] = 0;
			    	campo[4][1] = temp;
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
		    	}else if(campo[4][1]==0){
		    		temp = campo[3][1];
			    	campo[3][1] = 0;
			    	campo[4][1] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==4 && posicaoY==1){
		    	if(campo[3][1]==0){
		    		temp = campo[4][1];
			    	campo[4][1] = 0;
			    	campo[3][1] = temp;
		    	}else if(campo[4][0]==0){
		    		temp = campo[4][1];
			    	campo[4][1] = 0;
			    	campo[4][0] = temp;
		    	}else if(campo[4][2]==0){
		    		temp = campo[4][1];
			    	campo[4][1] = 0;
			    	campo[4][2] = temp;
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
		    	}else if(campo[4][2]==0){
		    		temp = campo[3][2];
			    	campo[3][2] = 0;
			    	campo[4][2] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==4 && posicaoY==2){
		    	if(campo[3][2]==0){
		    		temp = campo[4][2];
			    	campo[4][2] = 0;
			    	campo[3][2] = temp;
		    	}else if(campo[4][1]==0){
		    		temp = campo[4][2];
			    	campo[4][2] = 0;
			    	campo[4][1] = temp;
		    	}else if(campo[4][3]==0){
		    		temp = campo[4][2];
			    	campo[4][2] = 0;
			    	campo[4][3] = temp;
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
		    	}else if(campo[0][4]==0){
		    		temp = campo[0][3];
			    	campo[0][3] = 0;
			    	campo[0][4] = temp;
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
		    	}else if(campo[1][4]==0){
		    		temp = campo[1][3];
			    	campo[1][3] = 0;
			    	campo[1][4] = temp;
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
		    	}else if(campo[2][4]==0){
		    		temp = campo[2][3];
			    	campo[2][3] = 0;
			    	campo[2][4] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==3 && posicaoY==3){
		    	if(campo[2][3]==0){
		    		temp = campo[3][3];
			    	campo[3][3] = 0;
			    	campo[2][3] = temp;
		    	}else if(campo[3][2]==0){
		    		temp = campo[3][3];
			    	campo[3][3] = 0;
			    	campo[3][2] = temp;
		    	}else if(campo[4][3]==0){
		    		temp = campo[3][3];
			    	campo[3][3] = 0;
			    	campo[4][3] = temp;
		    	}else if(campo[3][4]==0){
		    		temp = campo[3][3];
			    	campo[3][3] = 0;
			    	campo[3][4] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==4 && posicaoY==3){
		    	if(campo[3][3]==0){
		    		temp = campo[4][3];
			    	campo[4][3] = 0;
			    	campo[3][3] = temp;
		    	}else if(campo[4][2]==0){
		    		temp = campo[4][3];
			    	campo[4][3] = 0;
			    	campo[4][2] = temp;
		    	}else if(campo[4][4]==0){
		    		temp = campo[4][3];
			    	campo[4][3] = 0;
			    	campo[4][4] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==0 && posicaoY==4){
		    	if(campo[0][3]==0){
		    		temp = campo[0][4];
			    	campo[0][4] = 0;
			    	campo[0][3] = temp;
		    	}else if(campo[1][4]==0){
		    		temp = campo[0][4];
			    	campo[0][4] = 0;
			    	campo[1][4] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==1 && posicaoY==4){
		    	if(campo[1][3]==0){
		    		temp = campo[1][4];
			    	campo[1][4] = 0;
			    	campo[1][3] = temp;
		    	}else if(campo[2][4]==0){
		    		temp = campo[1][4];
			    	campo[1][4] = 0;
			    	campo[2][4] = temp;
		    	}else if(campo[0][4]==0){
		    		temp = campo[1][4];
			    	campo[1][4] = 0;
			    	campo[0][4] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==2 && posicaoY==4){
		    	if(campo[2][3]==0){
		    		temp = campo[2][4];
			    	campo[2][4] = 0;
			    	campo[2][3] = temp;
		    	}else if(campo[3][4]==0){
		    		temp = campo[2][4];
			    	campo[2][4] = 0;
			    	campo[3][4] = temp;
		    	}else if(campo[1][4]==0){
		    		temp = campo[2][4];
			    	campo[2][4] = 0;
			    	campo[1][4] = temp;
		    	}else{
		    		return false;
		    	}
		    }else if(posicaoX==3 && posicaoY==4){
		    	if(campo[3][3]==0){
		    		temp = campo[3][4];
			    	campo[3][4] = 0;
			    	campo[3][3] = temp;
		    	}else if(campo[4][4]==0){
		    		temp = campo[3][4];
			    	campo[3][4] = 0;
			    	campo[4][4] = temp;
		    	}else if(campo[2][4]==0){
		    		temp = campo[3][4];
			    	campo[3][4] = 0;
			    	campo[2][4] = temp;
		    	}else{
		    		return false;
		    	}
		    }else{
		    	if(campo[4][3]==0){
		    		temp = campo[4][4];
			    	campo[4][4] = 0;
			    	campo[4][3] = temp;
		    	}else if(campo[3][4]==0){
		    		temp = campo[4][4];
			    	campo[4][4] = 0;
			    	campo[3][4] = temp;
		    	}else{
		    		return false;
		    	}
		    }	
		}
		return true;
	}
	
}
