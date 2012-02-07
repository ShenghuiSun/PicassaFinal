package model;

import java.util.List;

import model.util.PerlinNoise;


public class PerlinBWExpression extends ParenExpression{

    protected PerlinBWExpression (List<Expression> subexpressions) {
        super(subexpressions);
    }
    
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return PerlinNoise.greyNoise(results.get(0), results.get(1));
	}
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			// TODO Auto-generated method stub
			return "perlinBW";
		}

		@Override 
		protected int getNumParam() {
			// TODO Auto-generated method stub
			return 2;
		} 

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			// TODO Auto-generated method stub
			return new PerlinBWExpression(subExpressions);
		} 
		
	}
}

