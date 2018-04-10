package org.byters.engine.model;

public class Menu {

    public static final int NO_VALUE = -1;
    private int textBackID = NO_VALUE;
    private MenuData data;
    private MenuData currentMenu;
    private int currentIndex;
    private boolean isShown;

    public boolean isShown() {
        return isShown;
    }

    public void setTextBackID(int textBackID) {
        this.textBackID = textBackID;
    }

    public void topLevel() {
        if (!isShown) {
            isShown = true;
            return;
        }

        if (isShown && currentMenu != null && currentMenu.getId() == 0) {
            isShown = false;
            return;
        }

        navigateUp();
    }

    private void navigateUp() {
        //todo implement navigate up
    }

    public void selectItem() {
        if (isDrawBack() && currentIndex == getItemsCount() - 1)
            navigateUp();

        if (currentMenu == null || currentMenu.getChilds() == null || currentMenu.getChilds().size() <= currentIndex)
            return;

        currentMenu = currentMenu.getChilds().get(currentIndex);
        currentIndex = 0;
    }

    public void next() {
        if (currentMenu == null || getItemsCount() <= currentIndex)
            return;

        ++currentIndex;
        currentIndex %= getItemsCount();
    }

    public void previous() {
        if (currentMenu == null || getItemsCount() <= currentIndex)
            return;

        currentIndex = (getItemsCount() + currentIndex - 1) % getItemsCount();
    }

    public int getMenuTitleId(int position) {
        if (currentMenu == null || currentMenu.getChilds() == null) return NO_VALUE;

        if (position == getItemsCount() - 1 && isDrawBack())
            return textBackID;

        return currentMenu.getChilds().get(position).getTitleId();
    }

    public int getItemsCount() {
        return currentMenu == null || currentMenu.getChilds() == null
                ? 0
                : (currentMenu.getChilds().size() + (isDrawBack() ? 1 : 0));
    }

    private boolean isDrawBack() {
        return currentMenu != null && currentMenu.getId() != 0;
    }

    public void load(MenuData menuData) {
        data = menuData;
        currentMenu = data;
        currentIndex = 0;
        isShown = false;
    }

    public boolean isCurrentIndex(int position) {
        return position == currentIndex;
    }

    private int getId(int position) {
        return currentMenu == null || currentMenu.getChilds() == null || currentMenu.getChilds().size() <= position
                ? NO_VALUE
                : currentMenu.getChilds().get(position).getId();
    }

    public int getCurrentItemId() {
        return getId(currentIndex);
    }
}
