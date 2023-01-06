

public enum mois{
	JANVIER(1){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			return 31;
		}
	},FEVRIER(2){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			
			return 28;
		}
	},MARS(3){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			return 31;
		}
	},AVRIL(4){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			return 30;
		}
	},MAI(5){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			return 31;
		}
	},JUIN(6){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			return 30;
		}
	},JUILLET(7){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			return 31;
		}
	},AOUT(8){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			return 31;
		}
	},SEPTEMBRE(9){
		@Override
		public int Maxjdm() {
			// TODO Auto-generated method stub
			return 30;
		}
	},OCTOBRE(10){
		public int Maxjdm() {return 31;
			// TODO Auto-generated method stub
		
		}
	},NOVEMBRE(11){
	public int Maxjdm() {
		// TODO Auto-generated method stub
		return 30;
	}
},DESCENBRE(12){
	public int Maxjdm() {
		// TODO Auto-generated method stub
		return 31;
	}
};
/*-------*/private	final int n;

	//constructeur
	mois(int n)
	{this.n= n;}
	//
	public String toString()
	{
		return String.valueOf(n);
	}
	public abstract int Maxjdm();
	public int getMois()
	{
		switch(this.ordinal())
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:return 31;
		
		case 4:case 6:case 9:case 11:return 30;
		
		case 2:return 28;
		}
		return 0;
	}
	public static mois getMoisString(int n)throws DateException
	{
		for(mois moi : mois.values())
		{
			if(moi.ordinal()==n-1){return moi;}
		}
		throw new DateException("===moi invalid===");
	}
	public static mois getMoisString2(int n)
	{
		for(mois moi : mois.values())
		{
			if(moi.ordinal()==n-1){return moi;}
		}
		if ( n > 12)
		{int m = n % 12;
		
		for(mois moii : mois.values())
		{
			if(moii.ordinal()==m-1){return moii;}
		}}
		return mois.JANVIER;
	}
	
	
	}