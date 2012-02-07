package model;

public class TExpression extends WordExpression {
	
	@Override
	public RGBColor evaluate(double X, double Y) {
		return new RGBColor(Y);
	}

	public static class Factory extends WordExpression.Factory
	{

		@Override
		protected String commandWordName() {
			return "t";
		}

		@Override
		protected WordExpression constructWordExp() {
			return new TExpression(); 
		}
		
	}
}
