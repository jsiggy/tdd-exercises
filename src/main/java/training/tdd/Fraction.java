package training.tdd;

import lombok.EqualsAndHashCode;
import lombok.Setter;

@EqualsAndHashCode(exclude = "gcdProvider")
public class Fraction {
   private int numerator;
   private int denominator;
   @Setter GcdProvider gcdProvider = new SimpleGcdProvider();

   public Fraction(int numerator) {
      this(numerator, 1);
   }

   public Fraction(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
   }

   public Fraction plus(Fraction that) {
      if (this.denominator == 0 || that.denominator == 0)
         throw new IllegalArgumentException("Cannot add illegal fractions(zero divisor):" + this + that);

      if (this.denominator != that.denominator)
         return new Fraction((this.numerator * that.denominator) + (this.denominator * that.numerator), this.denominator * that.denominator);
      else
         return new Fraction(this.numerator + that.numerator, this.denominator);
   }

   @Override public String toString() {
      return numerator + "/" + denominator;
   }

   public Fraction reduce() {
      return new Fraction(numerator / gcdProvider.gcd(6, 4), denominator / gcdProvider.gcd(6, 4));
   }
}
