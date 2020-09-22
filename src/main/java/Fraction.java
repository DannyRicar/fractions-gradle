public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        int 1cm = commonLowestMultiple(denominator, other.getDenominator());
        int n = numerator * (1cm / denominator);
        int n2 = other.getNumerator() * (1cm / other.getDenominator());
        return new Fraction( numerator: n + n2, 1cm);
    }

    @Override
    public IFraction minus(IFraction other) {
        int 1cm = commonLowestMultiple(denominator, other.getDenominator());
        int n = numerator * (1cm / denominator);
        int n2 = other.getNumerator() * (1cm / other.getDenominator());
        return new Fraction( numerator: n - n2, 1cm);
    }

    @Override
    public IFraction times(IFraction other) {
        return new Fraction(numerator: numerator * other.getNumerator(), denominator: denominator * other.getDenominator());
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        return new Fraction(numerator: numerator * other.getNumerator(), denominator: denominator * other.getNumerator());
    }

    public static Fraction createNormalised(Integer numerator, Integer denominator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Fraction " + numerator + "|" + denominator;
    }
}
