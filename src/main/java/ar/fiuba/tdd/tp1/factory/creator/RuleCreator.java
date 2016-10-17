package ar.fiuba.tdd.tp1.factory.creator;

import ar.fiuba.tdd.tp1.rule.*;
import ar.fiuba.tdd.tp1.rule.utilities.ArithmeticalOperator;
import ar.fiuba.tdd.tp1.rule.utilities.ArithmeticalRuleOperators;
import ar.fiuba.tdd.tp1.rule.utilities.ComparisonOperator;

public enum RuleCreator {

    NO_REPETITION_RULE_CREATOR("no_rep") {
        @Override
        public Rule createRule(String value) {
            return new NoRepetitionRule(value);
        }
    },

    MULT_RULE_CREATOR("mult") {
        @Override
        public Rule createRule(String value) {
            int expectedValue = Integer.parseInt(value);
            int initAcumulator = 1;

            ArithmeticalRuleOperators operators = new ArithmeticalRuleOperators(
                    ArithmeticalOperator.MULT, ComparisonOperator.EQUAL,
                    ComparisonOperator.LESS
            );

            return new AccumulatorRule(expectedValue, operators, initAcumulator);
        }
    },

    SUM_RULE_CREATOR("sum") {
        @Override
        public Rule createRule(String value) {
            int expectedValue = Integer.parseInt(value);
            int initAcumulator = 0;

            ArithmeticalRuleOperators operators = new ArithmeticalRuleOperators(
                    ArithmeticalOperator.ADDITION, ComparisonOperator.EQUAL,
                    ComparisonOperator.LESS
            );
            return new AccumulatorRule(expectedValue, operators, initAcumulator);
        }
    };

    /*SUM_RULE_CREATOR("sum") {   //TODO: LE PUSE UN SUMRULE, PERO DESPUES HACEMOS LO TUYO DIEGO

        @Override               //TODO: Y QUIZAS DA PARA PONER UN TEMPLATE METHOD
        public Rule createRule(String value) {
            return new SumRule(Integer.parseInt(value));
        }
    },

    MULT_RULE_CREATOR("mult") {   //TODO: LE PUSE UN MULTRULE, PERO DESPUES HACEMOS LO TUYO DIEGO

        @Override
        public Rule createRule(String value) {
            return new MultRule(Integer.parseInt(value));
        }

    }*/

    private static final String DELIMITER = "_";

    public final String stringRepresentation;

    RuleCreator(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }


    public abstract Rule createRule(String value);


}
