public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;

        if (denominator == 0){
            throw new ArithmeticException("Cannot Divide by 0");
        }
        else this.denominator = denominator;
    }

    private Fraction reduceFraction(int numerator, int denominator) {
        int d;
        d = greatestCommonDivisor(numerator, denominator);

        numerator = numerator / d;
        denominator = denominator / d;
        return new Fraction(numerator, denominator);
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0)
            return a;
        return greatestCommonDivisor(b, a % b);
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
        return reduceFraction((numerator * other.getDenominator()) + (denominator * other.getNumerator()), denominator * other.getDenominator());
    }

    @Override
    public IFraction minus(IFraction other) {
        return reduceFraction((numerator * other.getDenominator()) - (denominator * other.getNumerator()), denominator * other.getDenominator());
    }

    @Override
    public IFraction times(IFraction other) {
        return reduceFraction(this.numerator * other.getNumerator(), this.denominator * other.getDenominator());
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        return reduceFraction(this.numerator * other.getDenominator(), this.denominator * other.getNumerator());
    }

}
