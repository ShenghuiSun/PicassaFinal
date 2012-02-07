package model;

import java.util.List;

import model.util.ColorCombinations;


public class YUVtoRGBExpression extends ParenExpression{

    protected YUVtoRGBExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
    
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.yuv(results.get(0));
	} 
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			return "yCrCbtoRGB";
		}

		@Override 
		protected int getNumParam() {
			return 1;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			return new YUVtoRGBExpression(subExpressions); 
		} 
		
	}
}
