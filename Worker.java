public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback=errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != 0 && i % 33==0){
                errorCallback.onError("Task " + i + " is done with an error");
                continue;
            }
            callback.onDone("Task " + i + " is done");
        }
    }
}
