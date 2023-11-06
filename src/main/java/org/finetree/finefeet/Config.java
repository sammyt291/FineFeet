package org.finetree.finefeet;

import redempt.redlib.config.annotations.Comment;

public class Config {

    @Comment("")
    @Comment("=====================")
    @Comment("=== MAIN SETTINGS ===")
    @Comment("=====================")

    @Comment("")
    @Comment("Should the plugin require the player to have the \"finefeet.use\" permission?")
    @Comment("Default: true")
    public static boolean usePermissions = true;

}
