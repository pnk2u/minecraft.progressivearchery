package solipingen.progressivearchery.registry.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import solipingen.progressivearchery.ProgressiveArchery;


public class ModItemTags {

    public static final TagKey<Item> FLETCHES = TagKey.of(RegistryKeys.ITEM, new Identifier(ProgressiveArchery.MOD_ID, "fletches"));
    
    
}
