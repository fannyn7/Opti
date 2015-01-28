package optAlgos;

public class Rechteck {

	int waagerechteSeite;
	int senkrechteSeite;
	
	// Position of the right-down corner
	int posX;
	int posY;
	
	public Rechteck(int wSeite, int sSeite){
		waagerechteSeite = wSeite;
		senkrechteSeite = sSeite;
	}

	
	public Rechteck(int wSeite, int sSeite, int x, int y){
		waagerechteSeite = wSeite;
		senkrechteSeite = sSeite;
		posX = x;
		posY = y;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getWSeite(){
		return waagerechteSeite;
	}
	
	public void setWSeite(int wSeite) {
		this.waagerechteSeite = wSeite;
	}
	
	public int getASeite(){
		return senkrechteSeite;
	}
	
	public void setASeite(int aSeite) {
		this.senkrechteSeite = aSeite;
	}

	public int getLange() {
		return Math.min(senkrechteSeite, waagerechteSeite);
	}

	
	public int getBreite() {
		return Math.max(senkrechteSeite, waagerechteSeite);
	}
	
	public float getFläche() {
		return waagerechteSeite*senkrechteSeite;
	}
	
	public int getPerimeter() {
		return 2*( waagerechteSeite + senkrechteSeite );
	}

	public float getProzentÜberlappung(Rechteck rechteck2) {
		
		int überLPosX = Math.max(this.posX, rechteck2.posX);
		int überLPosY = Math.max(this.posY, rechteck2.posY);
		int überLWSeite = Math.max( 0 , Math.min(this.posX+this.waagerechteSeite,
				rechteck2.posX+rechteck2.waagerechteSeite) - überLPosX);
		int überLSSeite = Math.max(0,Math.min(this.posY+this.senkrechteSeite,
				rechteck2.posY+rechteck2.senkrechteSeite) -überLPosY);
		
		Rechteck überlappungRechteck = new Rechteck(überLWSeite,überLSSeite,überLPosX,überLPosY);
		
		return  überlappungRechteck.getFläche() / 
				Math.min(this.getFläche(), rechteck2.getFläche());
		
	}
	
}
