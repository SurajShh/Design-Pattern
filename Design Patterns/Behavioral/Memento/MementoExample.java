class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        content = memento.getContent();
    }

    static class Memento {
        private final String content;

        public Memento(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }
}
