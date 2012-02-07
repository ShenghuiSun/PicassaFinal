package model;

public class XExpression extends WordExpression {
	
	@Override
	public RGBColor evaluate(double X, double Y) {
		return new RGBColor(X);
	}

	
	public static class Factory extends WordExpression.Factory
	{

		@Override
		protected String commandWordName() {
			return "x";
		}
 
		@Override
		protected WordExpression constructWordExp() {
			return new XExpression(); 
		}
		
	}	
}
