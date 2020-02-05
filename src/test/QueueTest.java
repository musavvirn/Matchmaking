package test;

import enums.QueueStateEnum;
import model.Queue;
import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    Queue q = new Queue();

    @Test
    public void testActivate() {
        q.setState(QueueStateEnum.INACTIVE);
        Assert.assertTrue(q.activate());
        Assert.assertTrue(q.activate());
        q.setState(QueueStateEnum.EMPTY);
        Assert.assertFalse(q.activate());
    }

    @Test
    public void testDeactivate() {
        q.setState(QueueStateEnum.INACTIVE);
        Assert.assertFalse(q.deactivate());
        q.activate();
        Assert.assertTrue(q.deactivate());
        Assert.assertFalse(q.deactivate());
    }


}
