package model;

import java.util.List;

import model.util.ColorCombinations;


public class RGBtoYUVExpression extends ParenExpression{

    protected RGBtoYUVExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
    
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.rbg(results.get(0));
	} 
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			return "rgbToYCrCb";
		}

		@Override 
		protected int getNumParam() {
			return 1;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			return new RGBtoYUVExpression(subExpressions); 
		} 
		
	}
}
