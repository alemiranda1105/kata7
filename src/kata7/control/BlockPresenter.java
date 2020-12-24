package kata7.control;

import kata7.model.Block;
import kata7.view.BlockDisplay;

public class BlockPresenter implements Block.Observer {
    private final Block block;
    private final BlockDisplay blockDisplay;

    public BlockPresenter(Block block, BlockDisplay blockDisplay) {
        this.block = block;
        this.blockDisplay = blockDisplay;
        this.block.register(this);
        this.blockDisplay.on((x, y) -> block.moveTo(x/100 + 1, Block.MAX - y/100));
        this.refresh();
    }

    @Override
    public void changed() {
        this.refresh();
    }

    private void refresh() {
        blockDisplay.paintBlock((block.x() - 1) * BlockDisplay.SIZE, (Block.MAX - block.y()) * BlockDisplay.SIZE);
    }



}
