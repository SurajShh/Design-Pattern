class Order {
    private final String item;
    private final String deliveryInstructions;
    private final String discountCode;

    private Order(Builder builder) {
        this.item = builder.item;
        this.deliveryInstructions = builder.deliveryInstructions;
        this.discountCode = builder.discountCode;
    }

    public static class Builder {
        private final String item;
        private String deliveryInstructions;
        private String discountCode;

        public Builder(String item) {
            this.item = item;
        }

        public Builder withDeliveryInstructions(String instructions) {
            this.deliveryInstructions = instructions;
            return this;
        }

        public Builder withDiscountCode(String code) {
            this.discountCode = code;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}

public class BuilderExample {
    public static void main(String[] args) {
        Order order = new Order.Builder("Laptop")
                .withDeliveryInstructions("Leave at front door")
                .withDiscountCode("SUMMER21")
                .build();
    }
}
