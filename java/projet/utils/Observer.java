package projet.utils;
/**
 * observer interface, used to update the views
 *
 */
public interface Observer {
	/**
	 * updates the given subject
	 * @param subj given subject
	 */
        public void update(Subject subj);
        /**
         * updates the given subject with the given data
         * @param subj the given subject
         * @param data the given data
         */
        public void update(Subject subj, Object data);
}
