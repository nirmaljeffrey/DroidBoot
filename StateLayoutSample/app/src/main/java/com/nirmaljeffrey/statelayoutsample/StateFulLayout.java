package com.nirmaljeffrey.statelayoutsample;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.AnyRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BindingMethods({
        @BindingMethod(type = StateFulLayout.class, attribute = "current_state", method = "setCurrentState"),
        @BindingMethod(type = StateFulLayout.class, attribute = "error_dialog_title", method = "setErrorDialogTitle"),
        @BindingMethod(type = StateFulLayout.class, attribute = "error_dialog_message", method = "setErrorDialogMessage"),
        @BindingMethod(type = StateFulLayout.class, attribute = "error_dialog_cancelable", method = "setCancelable"),
        @BindingMethod(type = StateFulLayout.class, attribute = "error_dialog_positive_text", method = "setErrorDialogPositiveText"),
        @BindingMethod(type = StateFulLayout.class, attribute = "error_dialog_negative_text", method = "setErrorDialogPositiveText"),
        @BindingMethod(type = StateFulLayout.class, attribute = "onRetryButtonClick", method = "setRetryButtonClickListener"),
        @BindingMethod(type = StateFulLayout.class, attribute = "onPositiveButtonClick", method = "setPositiveButtonClickListener"),
        @BindingMethod(type = StateFulLayout.class, attribute = "onNegativeButtonClick", method = "setNegativeButtonClickListener")
})
public class StateFulLayout extends FrameLayout {

    @IntDef({SUCCESS, EMPTY, ERROR, LOADING, OFFLINE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {}

    public static final String SAVED_INSTANCE_STATE = "instanceState";
    private static final String SAVED_STATE = "stateful_layout_state";

    @State
    private int currentState;
    @State
    private int currentStateAttribute;
    public static final int SUCCESS = 0;
    public static final int LOADING = 1;
    public static final int OFFLINE = 2;
    public static final int EMPTY = 3;
    public static final int ERROR = -1;
    private View contentView;
    private View loadingView;
    private View emptyView;
    private View offlineView;
    private AlertDialog errorDialogView;
    private PositiveButtonClickListener positiveButtonClickListener;
    private NegativeButtonClickListener negativeButtonClickListener;
    private RetryButtonClickListener retryButtonClickListener;
    private String errorDialogTitle;
    private String errorDialogMessage;
    private String errorDialogPositiveText;
    private String errorDialogNegativeText;
    private boolean isCancelable;
    @AnyRes
    private int contentViewId;
    @AnyRes
    private int offlineViewId;
    @AnyRes
    private int loadingViewId;
    @AnyRes
    private int emptyViewId;

    public StateFulLayout(@NonNull Context context) {
        this(context,null,0);
    }

    public StateFulLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public StateFulLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeParameters(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StateFulLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeParameters(context,attrs);
    }

    private void initializeParameters(Context context, AttributeSet attributeSet){
        TypedArray attributeArray = context.obtainStyledAttributes(attributeSet, R.styleable.StateFulLayout);
         currentStateAttribute = attributeArray.getInt(R.styleable.StateFulLayout_current_state, SUCCESS);
         contentViewId = attributeArray.getResourceId(R.styleable.StateFulLayout_content_layout_id,0);
         offlineViewId = attributeArray.getResourceId(R.styleable.StateFulLayout_offline_layout_id,0);
         loadingViewId = attributeArray.getResourceId(R.styleable.StateFulLayout_loading_layout_id,0);
         emptyViewId = attributeArray.getResourceId(R.styleable.StateFulLayout_empty_layout_id,0);
         boolean isCancelable = attributeArray.getBoolean(R.styleable.StateFulLayout_error_dialog_cancelable,true);
         String dialogTitle = attributeArray.getString(R.styleable.StateFulLayout_error_dialog_title);
         String dialogMessage = attributeArray.getString(R.styleable.StateFulLayout_error_dialog_message);
         String positiveText = attributeArray.getString(R.styleable.StateFulLayout_error_dialog_positive_text);
         String negativeText = attributeArray.getString(R.styleable.StateFulLayout_error_dialog_negative_text);
         attributeArray.recycle();
         if(offlineViewId == 0){
             offlineView = inflate(getContext(), R.layout.offline_layout,null);
         }
        if(dialogTitle == null){
            dialogTitle = getContext().getString(R.string.error);
        }
        setCancelable(isCancelable);
        setErrorDialogTitle(dialogTitle);
        setErrorDialogMessage(dialogMessage);
        setErrorDialogNegativeText(negativeText);
        setErrorDialogPositiveText(positiveText);
    }


    @Override
        protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(contentViewId != 0){
            contentView = findViewById(contentViewId);
        }
        if(loadingViewId != 0){
            loadingView = findViewById(loadingViewId);
        }
        if(emptyViewId != 0){
            emptyView = findViewById(emptyViewId);
        }
        if(offlineViewId != 0){
            offlineView = findViewById(offlineViewId);
        } else{
            addView(offlineView);
        }
        setCurrentState(currentStateAttribute);
    }

    public void setErrorDialogPositiveText(String errorDialogPositiveText) {
        this.errorDialogPositiveText = errorDialogPositiveText;
    }

    public void setErrorDialogNegativeText(String errorDialogNegativeText) {
        this.errorDialogNegativeText = errorDialogNegativeText;
    }

    public void setRetryButtonClickListener(RetryButtonClickListener retryButtonClickListener) {
        this.retryButtonClickListener = retryButtonClickListener;
        if(offlineViewId == 0){
            offlineView.setOnClickListener((view) -> this.retryButtonClickListener.onRetryButtonClick());
        }
    }

    public void setErrorDialogMessage(String errorDialogMessage) {
        this.errorDialogMessage = errorDialogMessage;
    }

    public void setErrorDialogTitle(String errorDialogTitle) {
        this.errorDialogTitle = errorDialogTitle;
    }

    public void setCancelable(boolean cancelable) {
        isCancelable = cancelable;
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SAVED_INSTANCE_STATE, super.onSaveInstanceState());
        saveInstanceState(bundle);
        return bundle;
    }


    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if(state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
                restoreInstanceState(bundle);
            state = bundle.getParcelable(SAVED_INSTANCE_STATE);
        }
        super.onRestoreInstanceState(state);
    }


    public int getCurrentState() {
        return currentState;
    }


    public void saveInstanceState(Bundle outState) {
            outState.putInt(SAVED_STATE, currentState);
    }


    public int restoreInstanceState(Bundle savedInstanceState) {
        int state = savedInstanceState.getInt(SAVED_STATE);
        setCurrentState(state);
        return state;
    }


    public void setCurrentState(@State int state){
        currentState = state;
        switch (currentState){
            case ERROR:
                showErrorView();
                break;
            case SUCCESS:
                showContentView();
                break;
            case LOADING:
                showLoadingView();
                break;
            case OFFLINE:
                showOfflineView();
                break;
            case EMPTY:
                showEmptyView();
                break;
        }
    }


    public void setPositiveButtonClickListener(PositiveButtonClickListener positiveButtonClickListener) {
        this.positiveButtonClickListener = positiveButtonClickListener;
    }

    public void setNegativeButtonClickListener(NegativeButtonClickListener negativeButtonClickListener) {
        this.negativeButtonClickListener = negativeButtonClickListener;
    }


    public AlertDialog getDialogWithMessageAndTitle() {
        if(errorDialogMessage == null) {
            throw new IllegalStateException("message should not be null in statefulLayout");
        }
        if(errorDialogNegativeText == null && errorDialogPositiveText  == null && positiveButtonClickListener == null && negativeButtonClickListener == null) {
            throw new IllegalStateException("Error dialog should have atleast one button action and text in statefulLayout");
        }
            MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(getContext());
                    alertDialogBuilder.setTitle(errorDialogTitle)
                    .setMessage(errorDialogMessage)
                    .setCancelable(isCancelable);
            if (errorDialogPositiveText != null) {
                alertDialogBuilder.setPositiveButton(errorDialogPositiveText, (dialog, which) -> {
                    dialog.dismiss();
                    if(positiveButtonClickListener != null) {
                        positiveButtonClickListener.onPositiveButtonClick();
                    }
                });
            }
            if (errorDialogNegativeText != null) {
                alertDialogBuilder.setNegativeButton(errorDialogNegativeText, (dialog, which) -> {
                    dialog.dismiss();
                    if(negativeButtonClickListener != null) {
                        negativeButtonClickListener.onNegativeButtonClick();
                    }
                });
            }
            return alertDialogBuilder.create();
    }


    public interface PositiveButtonClickListener {
        void onPositiveButtonClick();
    }

    public interface NegativeButtonClickListener {
        void onNegativeButtonClick();
    }

    public interface RetryButtonClickListener {
        void onRetryButtonClick();
    }

    private void showView(View view) {
        if (view != null) {
            view.setVisibility(VISIBLE);
        }
    }

    private void showErrorDialog(){
        errorDialogView = getDialogWithMessageAndTitle();
        errorDialogView.show();
    }

    private void hideErrorDialog(){
        if(errorDialogView != null && errorDialogView.isShowing()){
            errorDialogView.dismiss();
        }
    }

    private void hideView(View view) {
        if (view != null) {
            view.setVisibility(GONE);
        }
    }


    private void showContentView() {
        showView(contentView);
        hideView(emptyView);
        hideView(loadingView);
        hideView(offlineView);
        hideErrorDialog();
    }

    private void showEmptyView() {
        showView(emptyView);
        hideView(contentView);
        hideView(loadingView);
        hideView(offlineView);
        hideErrorDialog();
    }

    private void showErrorView() {
        showView(contentView);
        hideView(emptyView);
        hideView(loadingView);
        hideView(offlineView);
        showErrorDialog();
    }

    private void showLoadingView() {
        showView(loadingView);
        hideView(contentView);
        hideView(offlineView);
        hideView(emptyView);
        hideErrorDialog();
    }

    private void showOfflineView() {
        showView(offlineView);
        hideView(loadingView);
        hideView(contentView);
        hideView(emptyView);
        hideErrorDialog();
    }

}
