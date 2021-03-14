package de.bypixels.Utils.Texts;

import de.bypixels.Challanges;
import de.bypixels.Utils.Util;

public enum Durations {

    WRONGSTEP(Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.wrongstep.in"), Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.wrongstep.main"), Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.wrongstep.out")),
    PERMISSION(Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.permission.in"), Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.permission.main"), Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.permission.out")),
    ONEBLOCK(Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.oneblock.in"), Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.oneblock.main"), Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.oneblock.out")),
    ARGUMENTS(Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.arguments.in"), Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.arguments.main"), Challanges.getChallenges().getUtil().getFileHander().getInteger("animation.arguments.out"));


    Integer durationIn, durationMain, durationOut;

    public Integer getDurationIn() {
        return durationIn;
    }

    public Integer getDurationMain() {
        return durationMain;
    }

    public Integer getDurationOut() {
        return durationOut;
    }

    Durations(Integer durationIn, Integer durationMain, Integer durationOut) {
        this.durationIn = durationIn;
        this.durationMain = durationMain;
        this.durationOut = durationOut;
    }
}
