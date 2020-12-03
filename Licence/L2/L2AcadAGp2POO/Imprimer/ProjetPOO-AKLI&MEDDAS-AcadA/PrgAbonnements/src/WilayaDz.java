



public enum WilayaDz {
	 adrar(1),chlef(2),laghouat(3),oum_el_bouaghi(4),batna(5),béjaïa(6),biskra(7),béchar(8),blida(9),bouira(10),tamanrassset(11),tébessa(12)
	,tlemcen(13)
	,tiaret(14)
	,tizi_ouzou(15)
	,alger1(16)
	,djelfa(17)
	,jijel(18)
	,sétif(19)
	,saida(20)
	,skikda(21)
	,sidi_bel_abbes(22)
	,annaba(23)
	,guelma(24)
	,constantine(25)
	,médéa(26)
	,mostaganem(27)
	,m_sila(28)
	,mascara(29)
	,ouargla(30)
	,oran(31)
	,elbayadh(32)
	,illizi(33)
,bord_bouar_réridj(34)
	,boumerdès(35)
	,eltaref(36)
	,tindouf(37)
	,tissemsilt(38)
	,el_oued(39)
	,khenchela(40)
	,souk_ahras(41)
,tipaza(42)
	,mila(43)
	,aïn_defla(44)
	 ,naâma(45)
	 ,aïn_témouchent(46)
	 ,ghardaïa(47)
	 ,relizane(48);

private final int x;
WilayaDz(int m)
{
	this.x=m;;
}
public int getX() {
	return x;
}
public String toString()
{
	return String.valueOf(this.x);
}
public static void AfficherWilaya()
{
	System.out.println("Wilaya : ");
	for(WilayaDz wilaya: WilayaDz.values())
	{
		System.out.println(wilaya.getX()+"-"+wilaya.name());
	}
}
public static WilayaDz getWilayaDZ(int n)
{for(WilayaDz wilaya: WilayaDz.values())
{
	if(wilaya.ordinal() == n-1)return wilaya;
}
return null;
}

public static WilayaDz getWilayaString(int n)throws AdresseException
{
	for(WilayaDz m : WilayaDz.values())
	{
		if(m.ordinal()==n-1){return m;}
	}
	throw new AdresseException("===Wilaya invalide===");
}

	
}
