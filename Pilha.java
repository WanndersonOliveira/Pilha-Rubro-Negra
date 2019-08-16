public interface Pilha<Objeto>{
	public int sizePreta();
	public int sizeVermelha();
	public boolean isEmptyPreta();
	public boolean isEmptyVermelha();
	public Objeto topPreta() throws EPilhaVazia;
	public Objeto topVermelha() throws EPilhaVazia;
	public void pushPreta(Objeto o);
	public void pushVermelha(Objeto o);
	public Objeto popPreta() throws EPilhaVazia;
	public Objeto popVermelha() throws EPilhaVazia;
}