import java.util.Scanner;

public class Principal{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		PilhaRubroNegra<String> prb = new PilhaRubroNegra<String>(5);

		for(int i = 0; i < 7; i++){
			prb.pushPreta("Preta");
			prb.mostrarTudo();
		}

		for(int i = 0; i < 7; i++){
			prb.pushVermelha("Vermelha");
			prb.mostrarTudo();
		}

		for(int i = 0; i < 7; i++){
			prb.popPreta();
			prb.mostrarTudo();
		}

		for(int i = 0; i < 7; i++){
			prb.popVermelha();
			prb.mostrarTudo();
		}


	}
}
