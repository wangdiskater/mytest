package mytest.design.decorator.example1;

public abstract class Decorator extends AbstractComponent {
    private AbstractComponent component;

    public AbstractComponent getAbstractComponent() {
        return component;
    }

    public void setAbstractComponent(AbstractComponent abstractComponent) {
        this.component = abstractComponent;
    }

    @Override
    public void operation() {
        if (component != null) {
            component.operation();
        }
    }

}
