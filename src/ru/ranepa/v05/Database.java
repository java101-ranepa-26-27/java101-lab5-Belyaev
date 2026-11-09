package ru.ranepa.v05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    public static final List<LaundryItem> ITEMS = new ArrayList<>();
    public static final List<ShiftWorker> WORKERS = new ArrayList<>();
    public static final Map<String, LaundryItem> BY_NAME = new HashMap<>();
}
