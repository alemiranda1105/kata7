package kata7.view;

import kata7.model.Block;

public interface BlockDisplay extends Block.Observer {
    Block block();
    void display(Block block);
}
