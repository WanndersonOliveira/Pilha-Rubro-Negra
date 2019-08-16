public class PilhaRubroNegra<Objeto> implements Pilha<Objeto>{
	private Objeto array[];
	private int capacidade;
	private int tamPreta;
	private int tamVermelha;
	private int topPreta;
	private int topVermelha;

	//Estratégia de incremento: duplicação

	public PilhaRubroNegra(){
		this.capacidade = 10;
		this.tamVermelha = 0;
		this.tamPreta = 0;
		this.topVermelha = -1;
		this.topPreta = this.capacidade;
		array = (Objeto[]) new Object[capacidade];
	}

	public PilhaRubroNegra(int cap){
		this.capacidade = cap;
		this.tamVermelha = 0;
		this.tamPreta = 0;
		this.topVermelha = -1;
		this.topPreta = this.capacidade;
		array = (Objeto[]) new Object[capacidade];
	}

	public int sizePreta(){
		return this.tamPreta;
	}

	public int sizeVermelha(){
		return this.tamVermelha;
	}

	public boolean isEmptyVermelha(){
		boolean check = false;
		if(this.tamVermelha == 0){
			check = true;
		}

		return check;
	}

	public boolean isEmptyPreta(){
		boolean check = false;
		if(this.tamPreta == 0){
			check = true;
		}

		return check;
	}

	public Objeto topPreta() throws EPilhaVazia{
				//Trabalhar nesse algoritmo abaixo
				//Como passar pilha preta para um array maiors EPilhaVazia{
		if(isEmptyPreta()){
			throw new EPilhaVazia("A pilha preta esta vazia");
		}

		return this.array[topPreta];
	}

	public Objeto topVermelha() throws EPilhaVazia{
		if(isEmptyVermelha()){
			throw new EPilhaVazia("A pilha vermelha esta vazia");
		}

		return this.array[topVermelha];
	}

	public void pushVermelha(Objeto o){
		this.tamVermelha++;
		this.topVermelha++;

		if(array[topVermelha] != null){
			int capacidadeAnterior = this.capacidade;
			capacidadeAnterior--;

				this.capacidade=this.capacidade*2; //Estratégia de duplicação
				Objeto substituto[] = (Objeto[]) new Object[capacidade];

				for(int i = 0; i < this.tamVermelha; i++){
					substituto[i] = array[i]; //Correto
				}

				this.topPreta = (this.capacidade-this.tamPreta);
				for(int i = (this.capacidade-1); i >= this.topPreta; i--){
					substituto[i] = array[capacidadeAnterior];
					capacidadeAnterior--;
				}

				array = (Objeto[]) new Object[capacidade];

				for(int i = 0; i < this.capacidade; i++){
						array[i] = substituto[i];
				}
		}

		array[topVermelha] = o;
	}


	public void pushPreta(Objeto o){
		this.tamPreta++;
		this.topPreta--;

		if(array[topPreta] != null){
			int capacidadeAnterior = this.capacidade;
			capacidadeAnterior--;

				this.capacidade=this.capacidade*2; //Estratégia de duplicação
				Objeto substituto[] = (Objeto[]) new Object[capacidade];

				for(int i = 0; i < this.tamVermelha; i++){
					substituto[i] = array[i]; //Correto
				}

				this.topPreta = (this.capacidade-this.tamPreta);
				for(int i = (this.capacidade-1); i >= this.topPreta; i--){
					substituto[i] = array[capacidadeAnterior];
					capacidadeAnterior--;
				}

				array = (Objeto[]) new Object[capacidade];

				for(int i = 0; i < this.capacidade; i++){
						array[i] = substituto[i];
				}
		}

		this.array[topPreta] = o;
	}

	public Objeto popVermelha() throws EPilhaVazia{
		Objeto element;

		element = array[topVermelha];
		array[topVermelha] = null;

		tamVermelha--;
		topVermelha--;

		return element;
	}

	public Objeto popPreta() throws EPilhaVazia{
		Objeto element;

		element = array[topPreta];

		array[topPreta] = null;

		tamPreta--;
		topPreta++;

		return element;
	}

	public void mostrarVermelha(){
		System.out.println("Mostrando Pilha Vermelha...");
		System.out.println("");
		for(int i = 0; i <= topVermelha; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}

	public void mostrarPreta(){
		System.out.println("Mostrando Pilha Preta...");
		System.out.println("");

		for(int i = (capacidade-1); i >= topPreta; i--){
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}
}
