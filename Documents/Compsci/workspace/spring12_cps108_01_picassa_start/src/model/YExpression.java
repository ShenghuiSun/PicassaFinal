package model;

public class YExpression extends WordExpression {
	
	@Override
	public RGBColor evaluate(double X, double Y) { 
		return new RGBColor(Y);
	}

	public static class Factory extends WordExpression.Factory
	{

		@Override
		protected String commandWordName() {
			return "y";
		}

		@Override
		protected WordExpression constructWordExp() {
			return new YExpression(); 
		}
		
	}
}
