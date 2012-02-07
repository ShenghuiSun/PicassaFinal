package model;

import java.util.List;

import model.util.PerlinNoise;


public class PerlinColorExpression extends ParenExpression{

    protected PerlinColorExpression (List<Expression> subexpressions) {
        super(subexpressions);
    }
    
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return PerlinNoise.colorNoise(results.get(0), results.get(1));
	}
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			// TODO Auto-generated method stub
			return "perlinColor";
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
			return new PerlinColorExpression(subExpressions);
		} 
		
	}
}

